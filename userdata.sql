/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : userdata

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-11-13 10:20:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adm
-- ----------------------------
DROP TABLE IF EXISTS `adm`;
CREATE TABLE `adm` (
  `aid` int(255) NOT NULL AUTO_INCREMENT,
  `admName` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `admPassword` varchar(255) DEFAULT NULL COMMENT '密码',
  `admMoble` varchar(255) DEFAULT NULL COMMENT '手机号',
  `admEmail` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `z` (`admEmail`) USING BTREE,
  UNIQUE KEY `y` (`code`) USING BTREE,
  KEY `x` (`admEmail`,`admPassword`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adm
-- ----------------------------
INSERT INTO `adm` VALUES ('51', 'aaa', 'aaa', '132145465', '743090652@qq.com', '1', '3d60df80a7ba7a917d46dd95151880c4f0cba034e1a34f46a2d6761a8b8a878e');

-- ----------------------------
-- Table structure for categorytable
-- ----------------------------
DROP TABLE IF EXISTS `categorytable`;
CREATE TABLE `categorytable` (
  `categoryId` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorytable
-- ----------------------------
INSERT INTO `categorytable` VALUES ('1', '计算机视觉');
INSERT INTO `categorytable` VALUES ('2', '虚拟现实');

-- ----------------------------
-- Table structure for filetable
-- ----------------------------
DROP TABLE IF EXISTS `filetable`;
CREATE TABLE `filetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileFileName` varchar(255) DEFAULT NULL,
  `fileContentType` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `fileTitle` varchar(255) DEFAULT NULL,
  `fileContent` longtext,
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `categoryId` FOREIGN KEY (`categoryId`) REFERENCES `categorytable` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filetable
-- ----------------------------

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('1', 'jack', 'b2ecdd8101017c0f6c2efe4f1e10bd8d');
