|-- undefined
    |-- main
    |   |-- java
    |   |   |-- com
    |   |       |-- juzi
    |   |           |-- oerp
    |   |               |-- OerpApplication.java
    |   |               |-- common
    |   |               |   |-- constant
    |   |               |   |   |-- JWTConstants.java
    |   |               |   |-- exception
    |   |               |   |   |-- AuthenticationException.java
    |   |               |   |   |-- OERPException.java
    |   |               |   |-- interceptor
    |   |               |   |   |-- AuthenticationInterceptor.java
    |   |               |   |-- jackson
    |   |               |       |-- LocalDateTimeDeserializer.java
    |   |               |       |-- LocalDateTimeSerializer.java
    |   |               |-- config
    |   |               |   |-- MybatisPlusConfiguration.java
    |   |               |   |-- SpringMvcConfiguration.java
    |   |               |-- controller
    |   |               |   |-- AuthenticationController.java
    |   |               |   |-- admin
    |   |               |       |-- UserController.java
    |   |               |-- dao
    |   |               |   |-- UserDAO.java
    |   |               |-- mapper
    |   |               |   |-- UserInfoMapper.java
    |   |               |   |-- UserMapper.java
    |   |               |-- model
    |   |               |   |-- dto
    |   |               |   |   |-- CreateUserDTO.java
    |   |               |   |   |-- PageParamDTO.java
    |   |               |   |   |-- UpdateUserDTO.java
    |   |               |   |   |-- UserLoginDTO.java
    |   |               |   |   |-- UserRegistionDTO.java
    |   |               |   |-- po
    |   |               |   |   |-- UserInfoPO.java
    |   |               |   |   |-- UserPO.java
    |   |               |   |-- vo
    |   |               |       |-- UserInfoVO.java
    |   |               |       |-- UserLoginVO.java
    |   |               |       |-- response
    |   |               |           |-- CreateResponseVO.java
    |   |               |           |-- DeleteResponseVO.java
    |   |               |           |-- ResponseVO.java
    |   |               |-- service
    |   |               |   |-- AuthenticationService.java
    |   |               |   |-- UserInfoService.java
    |   |               |   |-- UserService.java
    |   |               |   |-- impl
    |   |               |       |-- AuthenticationServiceImpl.java
    |   |               |       |-- UserInfoServiceImpl.java
    |   |               |       |-- UserServiceImpl.java
    |   |               |-- util
    |   |                   |-- JWTUtils.java
    |   |-- resources
    |       |-- application.yml
    |       |-- banner.txt
    |       |-- oerp.sql
    |       |-- mybatis
    |           |-- xml
    |               |-- dao
    |               |   |-- UserDAO.xml
    |               |-- mapper
    |                   |-- UserInfoMapper.xml
    |                   |-- UserMapper.xml
    |-- test
        |-- java
        |   |-- com
        |       |-- juzi
        |           |-- oerp
        |               |-- CodeGenerator.java
        |               |-- OerpApplicationTests.java
        |               |-- PasswordTests.java
        |               |-- dao
        |               |   |-- UserInfoMapperTest.java
        |               |-- util
        |                   |-- JWTUtilsTest.java
        |-- resources
            |-- mybatis-plus
                |-- generator
                    |-- template
                        |-- entity.java.vm
