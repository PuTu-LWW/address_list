/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : personal_info

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-06-10 20:20:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `account` varchar(32) NOT NULL,
  `day` varchar(64) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `event` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES ('123', '2020-06-10', 'XX公园', 'XXX,XXXXX');

-- ----------------------------
-- Table structure for finance
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance` (
  `account` varchar(32) NOT NULL,
  `costid` varchar(32) NOT NULL,
  `income` float(32,2) DEFAULT NULL,
  `item` varchar(50) DEFAULT NULL,
  `cost` float(32,2) DEFAULT NULL,
  `when` varchar(64) DEFAULT NULL,
  `surplus` float(32,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES ('123', '1001', '950.00', 'KTV', '420.00', '2020-06-28', '530.00');

-- ----------------------------
-- Table structure for memo
-- ----------------------------
DROP TABLE IF EXISTS `memo`;
CREATE TABLE `memo` (
  `account` varchar(32) NOT NULL,
  `deadline` varchar(64) DEFAULT NULL,
  `place` varchar(20) DEFAULT NULL,
  `thing` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of memo
-- ----------------------------
INSERT INTO `memo` VALUES ('123', '2020-06-28', '学习通', '交思修作业');

-- ----------------------------
-- Table structure for phone
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `account` varchar(32) NOT NULL,
  `tel` bigint(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `workplace` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phone
-- ----------------------------
INSERT INTO `phone` VALUES ('123', '15416718996', '老王', '夕阳红', '辽宁', '无~');
INSERT INTO `phone` VALUES ('123', '14742513345', '老刘', '', '', '');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `account` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(6) DEFAULT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `birth` varchar(64) DEFAULT NULL,
  `nationality` varchar(6) DEFAULT NULL,
  `profession` varchar(32) DEFAULT NULL,
  `tel` bigint(11) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `qq` int(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('123', '123', 'porty', '男', '1582128000000', '汉族', '学生', '123456789', '北京市朝阳区', '123456');
