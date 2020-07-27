package com.juzi.oerp.common.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.juzi.oerp.model.dto.param.CreateExamPlaceParamDTO;
import com.juzi.oerp.model.dto.param.UpdateExamParamDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Juzi
 * @date 2020/7/25 21:10
 */
@Component
public class CreateExamParamDeserializer extends JsonDeserializer<UpdateExamParamDTO> {
    @Override
    public Class<?> handledType() {
        return UpdateExamParamDTO.class;
    }

    @Override
    public UpdateExamParamDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode treeNode = p.readValueAsTree();
        String title = treeNode.get("title").toString().replaceAll("\"", "");
        String description = treeNode.get("description").toString().replaceAll("\"", "");
        BigDecimal price = new BigDecimal(treeNode.get("price").toString());
        long beginTime = Long.parseLong(treeNode.get("beginTime").toString()) / 1000;
        ZoneOffset zone = ZoneOffset.ofHours(8);
        LocalDateTime beginTimeLocalDateTime = LocalDateTime.ofEpochSecond(beginTime, 0, zone);

        long endTime = Long.parseLong(treeNode.get("endTime").toString()) / 1000;
        LocalDateTime endTimeLocalDateTime = LocalDateTime.ofEpochSecond(endTime, 0, zone);

        Map<LocalDateTime, List<CreateExamPlaceParamDTO>> timePlace = new HashMap<>();
        TreeNode timePlaceTreeNode = treeNode.get("timePlace");
        timePlaceTreeNode.fieldNames().forEachRemaining(time -> {
            LocalDateTime examTime = LocalDateTime.ofEpochSecond(Long.parseLong(time) / 1000, 0, zone);
            TreeNode timePlaceTressNodeArray = timePlaceTreeNode.get(time);
            List<CreateExamPlaceParamDTO> createExamPlaceParamDTOList = new ArrayList<>();
            for (int i = 0; i < timePlaceTressNodeArray.size(); i++) {
                // 考试地点
                String examPlace = timePlaceTressNodeArray.get(i).get("examPlace").toString().replaceAll("\"", "");
                // 考试人数
                int peopleNumber = Integer.parseInt(timePlaceTressNodeArray.get(i).get("peopleNumber").toString());
                CreateExamPlaceParamDTO createExamPlaceParamDTO = new CreateExamPlaceParamDTO();
                createExamPlaceParamDTO
                        .setExamPlace(examPlace)
                        .setPeopleNumber(peopleNumber);
                createExamPlaceParamDTOList.add(createExamPlaceParamDTO);
            }
            timePlace.put(examTime, createExamPlaceParamDTOList);
        });

        UpdateExamParamDTO updateExamParamDTO = new UpdateExamParamDTO();
        updateExamParamDTO
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .setBeginTime(beginTimeLocalDateTime)
                .setEndTime(endTimeLocalDateTime)
                .setTimePlace(timePlace);
        return updateExamParamDTO;
    }
}
