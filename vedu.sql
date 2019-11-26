/*
Navicat MySQL Data Transfer

Source Server         : MySQL连接
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : vedu

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-26 10:56:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pe_course
-- ----------------------------
DROP TABLE IF EXISTS `pe_course`;
CREATE TABLE `pe_course` (
  `course_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(40) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pe_course
-- ----------------------------
INSERT INTO `pe_course` VALUES ('2', '语文');
INSERT INTO `pe_course` VALUES ('3', '计算机');

-- ----------------------------
-- Table structure for pe_title
-- ----------------------------
DROP TABLE IF EXISTS `pe_title`;
CREATE TABLE `pe_title` (
  `title_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `title_name` varchar(50) DEFAULT NULL,
  `course_id` int(10) DEFAULT NULL,
  `course_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`title_id`),
  KEY `SYS_Course` (`course_id`),
  CONSTRAINT `SYS_Course` FOREIGN KEY (`course_id`) REFERENCES `pe_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pe_title
-- ----------------------------
INSERT INTO `pe_title` VALUES ('1', 'java', '3', '计算机');
INSERT INTO `pe_title` VALUES ('3', 'javaweb', '3', '计算机');

-- ----------------------------
-- Table structure for pe_user
-- ----------------------------
DROP TABLE IF EXISTS `pe_user`;
CREATE TABLE `pe_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键用户id',
  `email` varchar(60) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '不能重复,可为中文',
  `login_times` int(10) DEFAULT '0' COMMENT '剩余登录次数',
  `search_times` int(10) DEFAULT '0' COMMENT '剩余查询次数',
  `password` varchar(64) DEFAULT NULL COMMENT 'shiro MD5密码32位',
  `state` decimal(11,0) DEFAULT NULL COMMENT '1启用0停用',
  `company_id` varchar(40) DEFAULT NULL,
  `company_name` varchar(40) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pe_user
-- ----------------------------
INSERT INTO `pe_user` VALUES ('1', 'jirongtian', '甜少不甜', '500', '500', '123456', '1', '1', '北京南天软件有限公司', '男', '18638001960', '2019-11-16 20:46:05', '2019-11-16 20:47:04', null);
INSERT INTO `pe_user` VALUES ('3', 'admin', 'boss', '1000', '1000', 'admin', '1', '1', '北京南天软件有限公司', '女', '1587965', '2019-11-16 20:47:29', '2019-11-16 20:51:13', null);
