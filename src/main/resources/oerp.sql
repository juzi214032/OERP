/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL8
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3307
 Source Schema         : oerp

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 18/07/2020 20:26:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试名称',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '考试页面信息：富文本',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片 url',
  `begin_time` timestamp(0) NOT NULL COMMENT '报名开始时间',
  `end_time` timestamp(0) NOT NULL COMMENT '报名截止时间',
  `price` decimal(10, 2) NOT NULL COMMENT '报名费用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, '大学英语四六级考试', '英语四六级考试是教育部主管的一项全国性的英语考试，其目的是对大学生的实际英语能力进行客观、准确的测量，为大学英语教学提供测评服务。大学英语考试是一项大规模标准化考试，是一个“标准关联的常模参照测验”。大学英语四、六级考试作为一项全国性的教学考试由“国家教育部高教司”主办，分为四级考试(CET-4) 和六级考试(CET-6)，每年各举行两次，分别在同一天的上午和下午进行。', '这是富文本描述', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1720152309,2634072306&fm=26&gp=0.jpg', '2020-07-01 00:00:00', '2020-07-11 00:00:00', 50.00, '2020-07-01 00:00:00', '2020-07-01 00:00:00');
INSERT INTO `exam` VALUES (2, '计算机二级考试', '计算机二级考试是全国计算机等级考试（National Computer Rank Examination，简称NCRE）四个等级中的一个等级，由教育部考试中心主办，考核计算机基础知识和使用一种高级计算机语言编写程序以及上机调试的基本技能。', NULL, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2544982474,620563023&fm=26&gp=0.jpg', '2020-09-02 00:00:00', '2020-09-15 00:00:00', 80.00, '2020-09-02 00:00:00', '2020-09-02 00:00:00');
INSERT INTO `exam` VALUES (3, '证券从业资格考试', '证券从业人员资格考试是由中国证券业协会负责组织的全国统一考试，证券资格是进入证券行业的必备证书，是进入银行或非银行金融机构、上市公司、投资公司、大型企业集团、财经媒体、政府经济部门的重要参考。', NULL, 'https://bkimg.cdn.bcebos.com/pic/960a304e251f95cac2173c11c3177f3e660952b2?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '2020-09-01 00:00:00', '2020-09-27 00:00:00', 122.00, '2020-09-01 00:00:00', '2020-09-01 00:00:00');
INSERT INTO `exam` VALUES (4, '普通话等级考试', '普通话水平测试（PSC：PUTONGHUA SHUIPING CESHI）是对应试人运用普通话的规范程度、熟练程度的口语考试。考试形式为口试。普通话水平等级分为三级六等，即一、二、三级，每个级别再分出甲乙两个等次；一级甲等为最高，三级乙等为最低。普通话水平测试不是口才的评定，而是对应试人掌握和运用普通话所达到的规范程度的测查和评定，是应试人的汉语标准语测试。', NULL, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=81229831,2255906362&fm=26&gp=0.jpg', '2020-10-01 00:00:00', '2020-10-14 00:00:00', 25.00, '2020-10-01 00:00:00', '2020-10-01 00:00:00');
INSERT INTO `exam` VALUES (6, '公务员考试', '公务员考试是公务员主管部门组织的担任主任科员以下及其他相当职务层次的非领导职务公务员的录用考试。采取公开考试、严格考察、平等竞争、择优录取的办法。民族自治地方依照前款规定录用公务员时，依照法律和有关规定对少数民族报考者予以适当照顾。中央机关及其直属机构公务员的录用，由中央公务员主管部门负责组织。地方各级机关公务员的录用，由省级公务员主管部门负责组织，必要时省级公务员主管部门可以授权设区的市级公务员主管部门组织。', NULL, 'https://bkimg.cdn.bcebos.com/pic/342ac65c103853431913c3299c13b07ecb8088de?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '2020-07-13 00:00:00', '2020-07-20 00:00:00', 100.00, '2020-07-13 00:00:00', '2020-07-13 00:00:00');
INSERT INTO `exam` VALUES (7, '期货从业资格考试', '期货从业人员资格考试是期货从业准入性质的入门考试，是全国性的执业资格考试。考试受中国证监会监督指导，由中国期货业协会主办，考务工作由ATA公司具体承办。', NULL, 'https://bkimg.cdn.bcebos.com/pic/ca1349540923dd5429dbb19cd109b3de9d82489d?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '2020-09-24 00:00:00', '2020-10-26 00:00:00', 65.00, '2020-09-24 00:00:00', '2020-09-24 00:00:00');
INSERT INTO `exam` VALUES (8, '雅思考试', '雅思考试， [1]  全称为国际英语测试系统（International English Language Testing System）简称雅思（IELTS），是著名的国际性英语标准化水平测试之一。雅思考试于1989年设立，由英国文化教育协会、剑桥大学考试委员会和澳大利亚教育国际开发署（IDP）共同管理。', NULL, 'https://bkimg.cdn.bcebos.com/pic/a5c27d1ed21b0ef4db81a446d6c451da81cb3eb8?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '2020-09-05 00:00:00', '2020-09-26 00:00:00', 2170.00, '2020-09-05 00:00:00', '2020-09-05 00:00:00');
INSERT INTO `exam` VALUES (9, '托福考试', '托福是由美国教育测验服务社（ETS）举办的英语能力考试，全名为“检定非英语为母语者的英语能力考试”，中文由TOEFL而音译为“托福”。TOEFL有三种，分别是： pbt—paper based test 纸考 677, cbt—computer based test 机考 300, ibt—internet based test 网考 120, 新托福满分是120分。TOEFL考试的有效期为两年，是从考试日期开始计算的。', NULL, 'https://bkimg.cdn.bcebos.com/pic/fcfaaf51f3deb48f18d06073fa1f3a292cf578e6?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '2020-09-12 00:00:00', '2020-09-23 00:00:00', 1985.00, '2020-09-12 00:00:00', '2020-09-12 00:00:00');
INSERT INTO `exam` VALUES (10, '注册会计师考试', '注册会计师，是指通过注册会计师执业资格考试并取得注册会计师证书在会计师事务所执业的人员，英文全称Certified Practising Accountant [1]  、Certified Public Accountant [2]  ，简称为CPA，注册会计师专业考试科目为《会计》、《审计》、《财务成本管理》、《经济法》、《税法》、《战略与风险管理》，综合阶段为：职业能力综合测试。', NULL, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1594978807557&di=2e14c6a9900f785b57ae30984de43d14&imgtype=0&src=http%3A%2F%2Fwww.zgcjpx.com%2Fuploadfile%2F2020%2F0102%2F20200102022153731.jpg', '2020-04-02 00:00:00', '2020-04-28 00:00:00', 480.00, '2020-04-02 00:00:00', '2020-04-02 00:00:00');
INSERT INTO `exam` VALUES (11, '安全工程师考试', '注册安全工程师执业资格考试实行全国统一大纲、统一命题、统一组织的考试制度，原则上每年举行一次。国家安全生产监督管理局负责拟定考试科目、编制考试大纲、编写考试用书、组织命题工作，统一规划考前培训等有关工作。考前培训工作按照培训与考试分开，自愿参加的原则进行。人事部负责审定考试科目、考试大纲和考试试题，组织实施考务工作。会同国家安全生产监督管理局对注册安全工程师执业资格考试进行检查、监督、指导和确定合格标准。', NULL, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1045291414,3630420629&fm=11&gp=0.jpg', '2020-09-14 00:00:00', '2020-09-25 00:00:00', 272.00, '2020-09-14 00:00:00', '2020-09-14 00:00:00');
INSERT INTO `exam` VALUES (12, '造价工程师', '造价工程师是通过全国造价工程师执业资格统一考试或者资格认定、资格互认，取得中华人民共和国造价工程师执业资格，并按照《注册造价工程师管理办法》注册，取得中华人民共和国造价工程师注册执业证书和执业印章，从事工程造价活动的专业人员。', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2415890686,2481157240&fm=11&gp=0.jpg', '2020-08-01 00:00:00', '2020-08-30 00:00:00', 161.00, '2020-08-01 00:00:00', '2020-08-01 00:00:00');
INSERT INTO `exam` VALUES (13, '基金从业考试', '基金从业资格考试，是为了进一步规范基金销售行为，提升从业人员能力。包含行业概括，法律法规与职业道德，投资管理，运作管理。销售管理，内部控制和合理管理，国际化等相关知识。', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1139877298,2932587906&fm=26&gp=0.jpg', '2020-09-16 00:00:00', '2020-10-07 00:00:00', 200.00, '2020-09-16 00:00:00', '2020-09-16 00:00:00');
INSERT INTO `exam` VALUES (14, '统计师考试', '统计师，国家统计局和人事部成立全国统计专业技术资格考试办公室，负责统计专业技术资格考试的组织实施和 考务工作，考试办公室设在国家统计局人事司。', NULL, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4184843483,3152403165&fm=26&gp=0.jpg', '2020-05-03 00:00:00', '2020-08-30 00:00:00', 140.00, '2020-05-03 00:00:00', '2020-05-03 00:00:00');
INSERT INTO `exam` VALUES (15, '银行从业考试', '银行从业资格考试是指“中国银行业从业人员资格认证” ，简称CCBP（Certification of China Banking Professional）。它是由中国银行业从业人员资格认证办公室负责组织和实施银行业从业人员资格考试。该考试认证制度，由四个基本的环节组成，即资格标准、考试制度、资格审核和继续教育。 考试科目为公共基础、个人理财、风险管理、个人贷款和公司信贷，其中公共基础为基础科目，其余为专业科目。考生可自行选择任意科目报考。按照《中国银行业从业人员资格认证考试证书管理办法》规定，通过“公共基础”考试并获得证书是获取专业证书的必要前提。', NULL, 'https://bkimg.cdn.bcebos.com/pic/e1fe9925bc315c60e718e04787b1cb134854778d?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '2020-03-27 00:00:00', '2020-05-05 00:00:00', 240.00, '2020-03-27 00:00:00', '2020-03-27 00:00:00');
INSERT INTO `exam` VALUES (16, '人力资源师考试', '人力资源管理师考试是获得人力资源职业资格的途径。人力资源管理师职业资格是国家人力资源和社会保障部推出的职业资格之一。是由国家人力资源和社会保障局和当地职业技能鉴定指导中心统一组织考试。全国统考一年两次，分别为每年五月份和十一月份，考试合格后由国家人力资源和社会保障局和当地职业技能鉴定指导中心联合颁发企业人力资源管理人员职业资格证书。', NULL, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1199123807,3239800409&fm=26&gp=0.jpg', '2020-03-19 00:00:00', '2020-03-31 00:00:00', 500.00, '2020-03-19 00:00:00', '2020-03-19 00:00:00');
INSERT INTO `exam` VALUES (17, '经济师考试', '经济专业技术资格实行全国统一考试制度，由全国统一组织、统一大纲、统一试题、统一评分标准。资格考试设置两个级别：经济专业初级资格、经济专业中级资格。参加考试并成绩合格者，获得相应级别的专业技术资格，由人事部统一发放合格证书。', NULL, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2701054350,3205044539&fm=26&gp=0.jpg', '2020-07-15 00:00:00', '2020-08-15 00:00:00', 120.00, '2020-07-15 00:00:00', '2020-07-15 00:00:00');
INSERT INTO `exam` VALUES (18, '一级消防工程师考试', '一级注册消防工程师资格考试由人力资源社会保障部人事考试中心统一组织实施，实行全国统一大纲、统一命题、统一组织的考试制度，每年人力资源社会保障部会下发考试计划，人事考试中心会公布具体考试时间。一级注册消防工程师资格考试定于每年第四季度进行。', NULL, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4194345199,2875102640&fm=26&gp=0.jpg', '2020-08-01 00:00:00', '2020-08-30 00:00:00', 210.00, '2020-08-01 00:00:00', '2020-08-01 00:00:00');
INSERT INTO `exam` VALUES (19, '执业药师考试', '国家执业药师资格考试是全国统一考试，合格后取得《中华人民共和国执业药师职业资格证书》。执业药师实行注册制度，从事药品生产、经营、使用和其他需要提供药学服务的单位，应当按规定配备相应的执业药师。', NULL, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=149310523,3479435990&fm=26&gp=0.jpg', '2020-07-20 00:00:00', '2020-08-10 00:00:00', 180.00, '2020-07-20 00:00:00', '2020-07-20 00:00:00');
INSERT INTO `exam` VALUES (20, '中级会计考试', '会计职称考试的全称是会计专业技术资格考试。会计职称考试是由财政部、人事部共同组织的全国统一考试，共分初级会计、中级会计师和高级会计师职称三个级别。考试实行全国统一考试制度，每年考试一次，由全国统一组织、统一大纲、统一试题，统一评分标准。', NULL, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3765503323,1252809076&fm=26&gp=0.jpg', '2020-03-10 00:00:00', '2020-07-20 00:00:00', 210.00, '2020-03-10 00:00:00', '2020-03-10 00:00:00');

-- ----------------------------
-- Table structure for exam_place
-- ----------------------------
DROP TABLE IF EXISTS `exam_place`;
CREATE TABLE `exam_place`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exam_time_id` int(11) NOT NULL COMMENT '考试时间 id',
  `exam_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试 地点',
  `people_number` int(11) NOT NULL COMMENT '最多报名人数。-1无限制',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试时间对应的考试地点' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_place
-- ----------------------------
INSERT INTO `exam_place` VALUES (1, 1, '重庆邮电大学', 1000, '2020-07-16 19:40:06', '2020-07-16 19:40:06');
INSERT INTO `exam_place` VALUES (2, 1, '重庆工商大学', 1000, '2020-07-17 19:40:06', '2020-07-17 19:40:06');
INSERT INTO `exam_place` VALUES (3, 1, '重庆第二师范学院', 300, '2020-07-18 19:40:06', '2020-07-18 19:40:06');
INSERT INTO `exam_place` VALUES (4, 1, '重庆理工大学', 500, '2020-07-19 19:40:06', '2020-07-19 19:40:06');
INSERT INTO `exam_place` VALUES (5, 2, '重庆邮电大学', 1000, '2020-07-20 19:40:06', '2020-07-20 19:40:06');
INSERT INTO `exam_place` VALUES (6, 2, '重庆工商大学', 1000, '2020-07-21 19:40:06', '2020-07-21 19:40:06');
INSERT INTO `exam_place` VALUES (7, 2, '重庆第二师范学院', 300, '2020-07-22 19:40:06', '2020-07-22 19:40:06');
INSERT INTO `exam_place` VALUES (8, 2, '重庆理工大学', 500, '2020-07-23 19:40:06', '2020-07-23 19:40:06');
INSERT INTO `exam_place` VALUES (9, 3, '西南大学', 500, '2020-07-24 19:40:06', '2020-07-24 19:40:06');
INSERT INTO `exam_place` VALUES (10, 3, '重庆邮电大学', 1000, '2020-07-25 19:40:06', '2020-07-25 19:40:06');
INSERT INTO `exam_place` VALUES (11, 3, '重庆工商大学', 1000, '2020-07-26 19:40:06', '2020-07-26 19:40:06');
INSERT INTO `exam_place` VALUES (12, 3, '重庆第二师范学院', 300, '2020-07-27 19:40:06', '2020-07-27 19:40:06');
INSERT INTO `exam_place` VALUES (13, 3, '重庆理工大学', 500, '2020-07-28 19:40:06', '2020-07-28 19:40:06');
INSERT INTO `exam_place` VALUES (14, 3, '重庆交通大学', 200, '2020-07-29 19:40:06', '2020-07-29 19:40:06');
INSERT INTO `exam_place` VALUES (15, 3, '重庆大学', 600, '2020-07-30 19:40:06', '2020-07-30 19:40:06');
INSERT INTO `exam_place` VALUES (16, 4, '西南大学', 500, '2020-07-31 19:40:06', '2020-07-31 19:40:06');
INSERT INTO `exam_place` VALUES (17, 4, '重庆邮电大学', 1000, '2020-08-01 19:40:06', '2020-08-01 19:40:06');
INSERT INTO `exam_place` VALUES (18, 4, '重庆工商大学', 1000, '2020-08-02 19:40:06', '2020-08-02 19:40:06');
INSERT INTO `exam_place` VALUES (19, 4, '重庆第二师范学院', 300, '2020-08-03 19:40:06', '2020-08-03 19:40:06');
INSERT INTO `exam_place` VALUES (20, 4, '重庆理工大学', 500, '2020-08-04 19:40:06', '2020-08-04 19:40:06');
INSERT INTO `exam_place` VALUES (21, 4, '重庆交通大学', 200, '2020-08-05 19:40:06', '2020-08-05 19:40:06');
INSERT INTO `exam_place` VALUES (22, 4, '重庆大学', 600, '2020-08-06 19:40:06', '2020-08-06 19:40:06');
INSERT INTO `exam_place` VALUES (23, 5, '重庆工程职业学院', 300, '2020-08-07 19:40:06', '2020-08-07 19:40:06');
INSERT INTO `exam_place` VALUES (24, 6, '重庆工程职业学院', 300, '2020-08-08 19:40:06', '2020-08-08 19:40:06');
INSERT INTO `exam_place` VALUES (25, 7, '重庆第二师范学院', 300, '2020-08-09 19:40:06', '2020-08-09 19:40:06');
INSERT INTO `exam_place` VALUES (26, 7, '重庆理工大学', 500, '2020-08-10 19:40:06', '2020-08-10 19:40:06');
INSERT INTO `exam_place` VALUES (27, 7, '重庆交通大学', 200, '2020-08-11 19:40:06', '2020-08-11 19:40:06');
INSERT INTO `exam_place` VALUES (28, 7, '重庆大学', 600, '2020-08-12 19:40:06', '2020-08-12 19:40:06');
INSERT INTO `exam_place` VALUES (29, 8, '重庆第二师范学院', 300, '2020-08-13 19:40:06', '2020-08-13 19:40:06');
INSERT INTO `exam_place` VALUES (30, 8, '重庆理工大学', 500, '2020-08-14 19:40:06', '2020-08-14 19:40:06');
INSERT INTO `exam_place` VALUES (31, 8, '重庆交通大学', 200, '2020-08-15 19:40:06', '2020-08-15 19:40:06');
INSERT INTO `exam_place` VALUES (32, 8, '重庆大学', 600, '2020-08-16 19:40:06', '2020-08-16 19:40:06');
INSERT INTO `exam_place` VALUES (33, 9, '重庆第二师范学院', 300, '2020-08-17 19:40:06', '2020-08-17 19:40:06');
INSERT INTO `exam_place` VALUES (34, 9, '重庆理工大学', 500, '2020-08-18 19:40:06', '2020-08-18 19:40:06');
INSERT INTO `exam_place` VALUES (35, 9, '重庆交通大学', 200, '2020-08-19 19:40:06', '2020-08-19 19:40:06');
INSERT INTO `exam_place` VALUES (36, 9, '重庆大学', 600, '2020-08-20 19:40:06', '2020-08-20 19:40:06');
INSERT INTO `exam_place` VALUES (37, 10, '重庆市巴南区李家沱', 100, '2020-08-21 19:40:06', '2020-08-21 19:40:06');
INSERT INTO `exam_place` VALUES (38, 11, '重庆市南岸区', 30, '2020-08-22 19:40:06', '2020-08-22 19:40:06');
INSERT INTO `exam_place` VALUES (39, 11, '重庆市渝中区', 40, '2020-08-23 19:40:06', '2020-08-23 19:40:06');
INSERT INTO `exam_place` VALUES (40, 11, '重庆市九龙坡区', 25, '2020-08-24 19:40:06', '2020-08-24 19:40:06');
INSERT INTO `exam_place` VALUES (41, 12, '四川外国语大学', 80, '2020-08-25 19:40:06', '2020-08-25 19:40:06');
INSERT INTO `exam_place` VALUES (42, 13, '观音桥步行街宏观鼎国际', 30, '2020-08-26 19:40:06', '2020-08-26 19:40:06');
INSERT INTO `exam_place` VALUES (43, 14, '观音桥步行街宏观鼎国际', 30, '2020-08-27 19:40:06', '2020-08-27 19:40:06');
INSERT INTO `exam_place` VALUES (44, 15, '观音桥步行街宏观鼎国际', 30, '2020-08-28 19:40:06', '2020-08-28 19:40:06');
INSERT INTO `exam_place` VALUES (45, 16, '观音桥步行街宏观鼎国际', 30, '2020-08-29 19:40:06', '2020-08-29 19:40:06');
INSERT INTO `exam_place` VALUES (46, 17, '观音桥步行街宏观鼎国际', 40, '2020-08-30 19:40:06', '2020-08-30 19:40:06');
INSERT INTO `exam_place` VALUES (47, 18, '观音桥步行街宏观鼎国际', 40, '2020-08-31 19:40:06', '2020-08-31 19:40:06');
INSERT INTO `exam_place` VALUES (48, 19, '观音桥步行街宏观鼎国际', 40, '2020-09-01 19:40:06', '2020-09-01 19:40:06');
INSERT INTO `exam_place` VALUES (49, 20, '观音桥步行街宏观鼎国际', 40, '2020-09-02 19:40:06', '2020-09-02 19:40:06');
INSERT INTO `exam_place` VALUES (50, 21, '重庆房地产职业学院', 60, '2020-09-03 19:40:06', '2020-09-03 19:40:06');
INSERT INTO `exam_place` VALUES (51, 22, '文理学院', 55, '2020-09-04 19:40:06', '2020-09-04 19:40:06');
INSERT INTO `exam_place` VALUES (52, 23, '城市科技大学', 23, '2020-09-05 19:40:06', '2020-09-05 19:40:06');
INSERT INTO `exam_place` VALUES (53, 24, '西南政法大学', 45, '2020-09-06 19:40:06', '2020-09-06 19:40:06');
INSERT INTO `exam_place` VALUES (54, 25, '重庆市渝中区龙湖时代天街', 30, '2020-09-07 19:40:06', '2020-09-07 19:40:06');
INSERT INTO `exam_place` VALUES (55, 26, '重庆理工大学', 35, '2020-09-08 19:40:06', '2020-09-08 19:40:06');
INSERT INTO `exam_place` VALUES (56, 27, '西南政法大学', 36, '2020-09-09 19:40:06', '2020-09-09 19:40:06');
INSERT INTO `exam_place` VALUES (57, 28, '文理学院', 42, '2020-09-10 19:40:06', '2020-09-10 19:40:06');
INSERT INTO `exam_place` VALUES (58, 29, '城市科技大学', 48, '2020-09-11 19:40:06', '2020-09-11 19:40:06');
INSERT INTO `exam_place` VALUES (59, 30, '重庆医科大学', 54, '2020-09-12 19:40:06', '2020-09-12 19:40:06');
INSERT INTO `exam_place` VALUES (60, 31, '人文科技学院', 50, '2020-09-13 19:40:06', '2020-09-13 19:40:06');

-- ----------------------------
-- Table structure for exam_time
-- ----------------------------
DROP TABLE IF EXISTS `exam_time`;
CREATE TABLE `exam_time`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exam_id` int(11) NOT NULL COMMENT '考试id',
  `exam_time` timestamp(0) NOT NULL COMMENT '考试时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试对应的考试时间，一对多' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_time
-- ----------------------------
INSERT INTO `exam_time` VALUES (1, 1, '2020-09-19 09:00:00', '2020-09-19 09:00:00', '2020-09-19 09:00:00');
INSERT INTO `exam_time` VALUES (2, 1, '2020-09-19 15:00:00', '2020-09-19 15:00:00', '2020-09-19 15:00:00');
INSERT INTO `exam_time` VALUES (3, 2, '2020-09-26 09:00:00', '2020-09-26 09:00:00', '2020-09-26 09:00:00');
INSERT INTO `exam_time` VALUES (4, 2, '2020-09-27 09:00:00', '2020-09-27 09:00:00', '2020-09-27 09:00:00');
INSERT INTO `exam_time` VALUES (5, 3, '2020-10-28 10:00:00', '2020-10-28 10:00:00', '2020-10-28 10:00:00');
INSERT INTO `exam_time` VALUES (6, 3, '2020-10-29 10:00:00', '2020-10-29 10:00:00', '2020-10-29 10:00:00');
INSERT INTO `exam_time` VALUES (7, 4, '2020-12-01 09:00:00', '2020-12-01 09:00:00', '2020-12-01 09:00:00');
INSERT INTO `exam_time` VALUES (8, 4, '2020-12-02 09:00:00', '2020-12-02 09:00:00', '2020-12-02 09:00:00');
INSERT INTO `exam_time` VALUES (9, 4, '2020-12-03 09:00:00', '2020-12-03 09:00:00', '2020-12-03 09:00:00');
INSERT INTO `exam_time` VALUES (10, 5, '2020-11-04 09:00:00', '2020-11-04 09:00:00', '2020-11-04 09:00:00');
INSERT INTO `exam_time` VALUES (11, 6, '2020-08-22 09:00:00', '2020-08-22 09:00:00', '2020-08-22 09:00:00');
INSERT INTO `exam_time` VALUES (12, 7, '2020-11-10 09:00:00', '2020-11-10 09:00:00', '2020-11-10 09:00:00');
INSERT INTO `exam_time` VALUES (13, 8, '2020-10-05 09:30:00', '2020-10-05 09:30:00', '2020-10-05 09:30:00');
INSERT INTO `exam_time` VALUES (14, 8, '2020-10-12 09:30:00', '2020-10-12 09:30:00', '2020-10-12 09:30:00');
INSERT INTO `exam_time` VALUES (15, 8, '2020-10-17 09:30:00', '2020-10-17 09:30:00', '2020-10-17 09:30:00');
INSERT INTO `exam_time` VALUES (16, 8, '2020-10-26 09:30:00', '2020-10-26 09:30:00', '2020-10-26 09:30:00');
INSERT INTO `exam_time` VALUES (17, 9, '2020-10-10 09:30:00', '2020-10-10 09:30:00', '2020-10-10 09:30:00');
INSERT INTO `exam_time` VALUES (18, 9, '2020-10-17 09:30:00', '2020-10-17 09:30:00', '2020-10-17 09:30:00');
INSERT INTO `exam_time` VALUES (19, 9, '2020-10-24 09:30:00', '2020-10-24 09:30:00', '2020-10-24 09:30:00');
INSERT INTO `exam_time` VALUES (20, 9, '2020-10-31 09:30:00', '2020-10-31 09:30:00', '2020-10-31 09:30:00');
INSERT INTO `exam_time` VALUES (21, 10, '2020-10-13 09:00:00', '2020-10-13 09:00:00', '2020-10-13 09:00:00');
INSERT INTO `exam_time` VALUES (22, 11, '2020-10-27 10:30:00', '2020-10-27 10:30:00', '2020-10-27 10:30:00');
INSERT INTO `exam_time` VALUES (23, 12, '2020-10-27 10:30:00', '2020-10-27 10:30:00', '2020-10-27 10:30:00');
INSERT INTO `exam_time` VALUES (24, 13, '2020-10-20 10:00:00', '2020-10-20 10:00:00', '2020-10-20 10:00:00');
INSERT INTO `exam_time` VALUES (25, 14, '2020-10-21 10:00:00', '2020-10-21 10:00:00', '2020-10-21 10:00:00');
INSERT INTO `exam_time` VALUES (26, 15, '2020-06-02 09:00:00', '2020-06-02 09:00:00', '2020-06-02 09:00:00');
INSERT INTO `exam_time` VALUES (27, 16, '2020-10-23 10:00:00', '2020-10-23 10:00:00', '2020-10-23 10:00:00');
INSERT INTO `exam_time` VALUES (28, 17, '2020-10-21 09:00:00', '2020-10-21 09:00:00', '2020-10-21 09:00:00');
INSERT INTO `exam_time` VALUES (29, 18, '2020-10-25 10:00:00', '2020-10-25 10:00:00', '2020-10-25 10:00:00');
INSERT INTO `exam_time` VALUES (30, 19, '2020-12-26 10:00:00', '2020-12-26 10:00:00', '2020-12-26 10:00:00');
INSERT INTO `exam_time` VALUES (31, 20, '2020-11-27 10:00:00', '2020-11-27 10:00:00', '2020-11-27 10:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '角色：0普通用户/1管理员',
  `status` tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '账号状态：0正常/1冻结',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'juzi', '15687899843', '0e9a512ca08cc66fea479658cda55c01', 01, 00, '2020-07-13 20:18:21', '2020-07-17 10:30:58');
INSERT INTO `user` VALUES (2, 'spring', '15923456781', '0f6cfb39422fa6fcc8eaf07118d1f29c', 01, 00, '2020-07-14 20:18:21', '2020-07-18 10:30:58');
INSERT INTO `user` VALUES (3, 'changcheng', '18423281997', '5200afabbf07386aef223ab3f2b88c3d', 01, 00, '2020-07-15 20:18:21', '2020-07-19 10:30:58');
INSERT INTO `user` VALUES (4, 'Yangth', '18223806310', 'e10adc3949ba59abbe56e057f20f883e', 01, 00, '2020-07-16 20:18:21', '2020-07-20 10:30:58');
INSERT INTO `user` VALUES (5, 'JIUGE', '17784456799', '8ddcff3a80f4189ca1c9d4d902c3c909', 01, 00, '2020-07-17 20:18:21', '2020-07-21 10:30:58');
INSERT INTO `user` VALUES (6, 'AFC', '15923424062', '25f9e794323b453885f5181f1b624d0b', 01, 00, '2020-07-18 20:18:21', '2020-07-22 10:30:58');
INSERT INTO `user` VALUES (7, 'SUNING', '17642554621', 'ef4753431fb8ee27cafd9d891923e8f2', 01, 00, '2020-07-19 20:18:21', '2020-07-23 10:30:58');
INSERT INTO `user` VALUES (8, 'SAFAW', '13423624211', '8384e60af83fd41c2499febc8cc9632c', 01, 00, '2020-07-20 20:18:21', '2020-07-24 10:30:58');
INSERT INTO `user` VALUES (9, 'GEHSCS', '13665772151', '4979ef5aab8e21fd1ad292a9df6a2696', 01, 00, '2020-07-21 20:18:21', '2020-07-25 10:30:58');
INSERT INTO `user` VALUES (10, 'SFAG', '15478942361', 'd625d5c27a7df049c556b9c5f3fb2411', 01, 00, '2020-07-22 20:18:21', '2020-07-26 10:30:58');
INSERT INTO `user` VALUES (11, 'xinran', '17452364812', '6499b373b4be3a0da027af76b1f9d378', 01, 00, '2020-07-23 20:18:21', '2020-07-27 10:30:58');
INSERT INTO `user` VALUES (12, 'xiehualin', '17945641245', '19d6a6e5d7089a60046a6fd29f4987ae', 01, 00, '2020-07-24 20:18:21', '2020-07-28 10:30:58');
INSERT INTO `user` VALUES (13, 'yangruiyan', '15623475236', '9dc26f3bdb576085b5947249e7c858e2', 01, 00, '2020-07-25 20:18:21', '2020-07-29 10:30:58');
INSERT INTO `user` VALUES (14, 'chenli', '13254789651', '86696270a93b7fab87589f51ed5c9b2f', 01, 00, '2020-07-26 20:18:21', '2020-07-30 10:30:58');
INSERT INTO `user` VALUES (15, 'zhangshufan', '15723469242', '436ebd82a399808f0056f974dae98047', 01, 00, '2020-07-27 20:18:21', '2020-07-31 10:30:58');
INSERT INTO `user` VALUES (16, 'wangzhengyao', '19984756123', '07173d000c9b6a17ec4b1de6df14b3cf', 01, 00, '2020-07-28 20:18:21', '2020-08-01 10:30:58');
INSERT INTO `user` VALUES (17, 'juqingsong', '13578912348', '89a07c46405e9fd3850f5443d6da2ec5', 01, 00, '2020-07-29 20:18:21', '2020-08-02 10:30:58');
INSERT INTO `user` VALUES (18, 'java', '18918945214', 'a804ec082b771cbf03e3e2d8cea2036c', 01, 00, '2020-07-30 20:18:21', '2020-08-03 10:30:58');
INSERT INTO `user` VALUES (19, 'perks', '19112849450', '02c75fb22c75b23dc963c7eb91a062cc', 01, 00, '2020-07-31 20:18:21', '2020-08-04 10:30:58');
INSERT INTO `user` VALUES (20, 'karasa', '19754235222', 'c1e37e248fc72d9d996cead3e2944109', 01, 00, '2020-08-01 20:18:21', '2020-08-05 10:30:58');
INSERT INTO `user` VALUES (21, 'Tian', '17855566624', 'f5720065118de93a8c087cef8e5c4f61', 01, 00, '2020-08-02 20:18:21', '2020-08-06 10:30:58');
INSERT INTO `user` VALUES (22, 'danbo', '17266666789', '6653ff91c686a5a50e4ad174d6dd92f9', 01, 00, '2020-08-03 20:18:21', '2020-08-07 10:30:58');
INSERT INTO `user` VALUES (23, 'Gudao', '15246348796', '020124446387ce78b18b3d532d641151', 01, 00, '2020-08-04 20:18:21', '2020-08-08 10:30:58');
INSERT INTO `user` VALUES (24, 'Zhiyuan', '18214567893', 'e972ce1871ad9bb46bcc72dbc3c55694', 01, 00, '2020-08-05 20:18:21', '2020-08-09 10:30:58');
INSERT INTO `user` VALUES (25, 'excel', '17754689234', '7ccdd1b7223db804f89e7c36144d138a', 01, 00, '2020-08-06 20:18:21', '2020-08-10 10:30:58');
INSERT INTO `user` VALUES (26, 'powerpoint', '17645823489', '59dac806f7b8ac45fc275dc8e3477fdd', 01, 00, '2020-08-07 20:18:21', '2020-08-11 10:30:58');
INSERT INTO `user` VALUES (27, 'BIANCHENG', '13345678925', 'a7d43eb7a89b8642d2e8abef58bb96c2', 01, 00, '2020-08-08 20:18:21', '2020-08-12 10:30:58');
INSERT INTO `user` VALUES (28, 'Changan', '19901230015', '7f5b6f9fa641b4634d2bd549e1b0e9b4', 01, 00, '2020-08-09 20:18:21', '2020-08-13 10:30:58');
INSERT INTO `user` VALUES (29, 'kangqiao', '18423246157', '2f485989180d1e4638c1a9d4872180de', 01, 00, '2020-08-10 20:18:21', '2020-08-14 10:30:58');
INSERT INTO `user` VALUES (30, 'Friday', '15789246351', '653b1752621a45700ec32c080cc9ffa1', 01, 00, '2020-08-11 20:18:21', '2020-08-15 10:30:58');

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `exam_id` int(11) NOT NULL COMMENT '考试id',
  `exam_time_id` int(11) NOT NULL COMMENT '考试时间id',
  `exam_place_id` int(11) NOT NULL COMMENT '考试地点id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '报名状态：\r\n0 - 已申请\r\n1 - 已支付\r\n2 - 审核通过\r\n3 - 审核未通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户考试报名信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_exam
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803' COMMENT '头像',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `photo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片url',
  `gender` tinyint(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '性别：0未知/1男/2女',
  `identity_no` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `birthday` timestamp(0) NULL DEFAULT NULL COMMENT '生日',
  `education` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '桔子', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803', '鞠青松', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2195111047,2119160749&fm=26&gp=0.jpg', 00, '511228199811019897', '1998-11-01 00:00:00', '本科', '2020-07-14 15:27:39', '2020-07-14 15:27:39');
INSERT INTO `user_info` VALUES (2, 'spring', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641804', '谢华林', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=114995272,318013098&fm=26&gp=0.jpg', 01, '500229199707022573', '1997-07-02 00:00:00', '本科', '2020-07-15 15:27:39', '2020-07-15 15:27:39');
INSERT INTO `user_info` VALUES (3, '长城', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641805', '王铮垚', 'https://t7.baidu.com/it/u=2516856125,3082337808&fm=193', 01, '500224199911220241', '1999-11-22 00:00:00', '本科', '2020-07-16 15:27:39', '2020-07-16 15:27:39');
INSERT INTO `user_info` VALUES (4, 'Yangth', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641806', '杨瑞妍', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3122303649,1920064789&fm=26&gp=0.jpg', 02, '500224199902220242', '1999-02-22 00:00:00', '本科', '2020-07-17 15:27:39', '2020-07-17 15:27:39');
INSERT INTO `user_info` VALUES (5, 'JIUGE', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641807', '陈力', 'https://t7.baidu.com/it/u=2516856125,3082337808&fm=193', 01, '500225199811222355', '1998-11-22 00:00:00', '本科', '2020-07-18 15:27:39', '2020-07-18 15:27:39');
INSERT INTO `user_info` VALUES (6, 'AFC', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641808', '张书凡', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1023029872,2088050734&fm=26&gp=0.jpg', 01, '500221199803062351', '1998-03-06 00:00:00', '本科', '2020-07-19 15:27:39', '2020-07-19 15:27:39');
INSERT INTO `user_info` VALUES (7, 'SUNING', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641809', '汪佳禹', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3122303649,1920064789&fm=26&gp=0.jpg', 02, '500229199712190248', '1997-12-19 00:00:00', '本科', '2020-07-20 15:27:39', '2020-07-20 15:27:39');
INSERT INTO `user_info` VALUES (8, 'SAFAW', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641810', '王静', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3122303649,1920064789&fm=26&gp=1.jpg', 02, '500229199706151122', '1997-06-15 00:00:00', '专科', '2020-07-21 15:27:39', '2020-07-21 15:27:39');
INSERT INTO `user_info` VALUES (14, 'chenli', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641816', '汪术青', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=177874340,1415909283&fm=26&gp=0.jpg', 02, '544123199805052248', '1998-05-05 00:00:00', '本科', '2020-07-27 15:27:39', '2020-07-27 15:27:39');
INSERT INTO `user_info` VALUES (15, 'zhangshufan', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641817', '周薇', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=163131711,2427143440&fm=26&gp=0.jpg', 01, '500229199712112135', '1997-12-11 00:00:00', '本科', '2020-07-28 15:27:39', '2020-07-28 15:27:39');
INSERT INTO `user_info` VALUES (16, 'wangzhengyao', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641818', '陈凤浪', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1707765092,1490402900&fm=26&gp=0.jpg', 01, '441856199512134521', '1995-12-13 00:00:00', '专科', '2020-07-29 15:27:39', '2020-07-29 15:27:39');
INSERT INTO `user_info` VALUES (17, 'juqingsong', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641819', '肖秋', 'https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3801480456,1509551869&fm=26&gp=0.jpg', 02, '500229199803218864', '1998-03-21 00:00:00', '硕士', '2020-07-30 15:27:39', '2020-07-30 15:27:39');
INSERT INTO `user_info` VALUES (18, 'java', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641820', '徐双', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3814177250,14517488&fm=26&gp=0.jpg', 02, '51222819971206264', '1997-12-06 00:00:00', '专科', '2020-07-31 15:27:39', '2020-07-31 15:27:39');
INSERT INTO `user_info` VALUES (20, 'karasa', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641822', '李倩', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1964653296,830809557&fm=26&gp=0.jpg', 02, '371728199809279070', '1998-09-27 00:00:00', '本科', '2020-08-02 15:27:39', '2020-08-02 15:27:39');
INSERT INTO `user_info` VALUES (22, '淡泊', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641824', '戴雨坊', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2509685299,488526854&fm=26&gp=0.jpg', 01, '130426199808106031', '1999-01-21 00:00:00', '硕士', '2020-08-04 15:27:39', '2020-08-04 15:27:39');
INSERT INTO `user_info` VALUES (23, '孤岛', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641825', '海杨', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2509685299,488526854&fm=26&gp=0.jpg', 00, '510422199903243023', '1999-03-24 00:00:00', '本科', '2020-08-05 15:27:39', '2020-08-05 15:27:39');
INSERT INTO `user_info` VALUES (25, 'excel', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641827', '马冬梅', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2920591862,2676043456&fm=26&gp=0.jpg', 02, '36100119970426330X', '1997-04-26 00:00:00', '本科', '2020-08-07 15:27:39', '2020-08-07 15:27:39');
INSERT INTO `user_info` VALUES (26, 'powerpoint', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641828', '袁华', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=353028913,3446845740&fm=26&gp=0.jpg', 01, '441521199504303333', '1995-04-30 00:00:00', '硕士', '2020-08-08 15:27:39', '2020-08-08 15:27:39');
INSERT INTO `user_info` VALUES (27, '边城', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641829', '王玉佳', 'https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1655987895,3195250907&fm=26&gp=0.jpg', 02, '500226199901212208', '1999-01-21 00:00:00', '本科', '2020-08-09 15:27:39', '2020-08-09 15:27:39');
INSERT INTO `user_info` VALUES (28, '长安', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641830', '杜林', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2920591862,2676043456&fm=26&gp=0.jpg', 02, '500229199612208420', '1996-12-20 00:00:00', '本科', '2020-08-10 15:27:39', '2020-08-10 15:27:39');
INSERT INTO `user_info` VALUES (29, '康桥', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641831', '余群', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3848391979,3675018204&fm=26&gp=0.jpg', 00, '51122719980621208x', '1998-06-21 00:00:00', '专科', '2020-08-11 15:27:39', '2020-08-11 15:27:39');

SET FOREIGN_KEY_CHECKS = 1;
