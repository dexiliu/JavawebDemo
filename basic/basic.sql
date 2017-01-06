/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : basic

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2013-06-24 22:32:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_permission`
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` char(10) NOT NULL DEFAULT '' COMMENT '权限名',
  `value` char(20) NOT NULL DEFAULT '' COMMENT '权限值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='权限列表';

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES ('13', '', 'student:add');
INSERT INTO `auth_permission` VALUES ('14', '', 'student:edit');
INSERT INTO `auth_permission` VALUES ('15', '', 'student:save');
INSERT INTO `auth_permission` VALUES ('16', '', 'student:delete');

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `weight` tinyint(1) NOT NULL COMMENT '角色权重，决定显示顺序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('1', 'admin', '1');
INSERT INTO `auth_role` VALUES ('5', 'teacher', '2');
INSERT INTO `auth_role` VALUES ('6', 'monitor', '3');

-- ----------------------------
-- Table structure for `auth_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_permission`;
CREATE TABLE `auth_role_permission` (
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `permission_id` int(8) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`),
  CONSTRAINT `auth_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定义每个角色都包含哪些角色\r\n含有外键，role被删除时，role_permission中的映射数据级联被删除';

-- ----------------------------
-- Records of auth_role_permission
-- ----------------------------
INSERT INTO `auth_role_permission` VALUES ('1', '13');
INSERT INTO `auth_role_permission` VALUES ('1', '14');
INSERT INTO `auth_role_permission` VALUES ('1', '15');
INSERT INTO `auth_role_permission` VALUES ('1', '16');
INSERT INTO `auth_role_permission` VALUES ('5', '13');
INSERT INTO `auth_role_permission` VALUES ('5', '14');
INSERT INTO `auth_role_permission` VALUES ('5', '15');
INSERT INTO `auth_role_permission` VALUES ('5', '16');
INSERT INTO `auth_role_permission` VALUES ('6', '12');

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '昵称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('1', 'admin', '123', 'admin');
INSERT INTO `auth_user` VALUES ('2', 'teacher', '123', 'teacher');
INSERT INTO `auth_user` VALUES ('3', 'monitor', '123', 'monitor');

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `user_id` int(8) NOT NULL,
  `role_id` int(8) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  CONSTRAINT `auth_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户拥有的角色表\r\n含外键\r\n用户删除时对应的映射数据会级联删除';

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES ('1', '1');
INSERT INTO `auth_user_role` VALUES ('2', '5');
INSERT INTO `auth_user_role` VALUES ('3', '6');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `email` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='学生表，演示代码专用';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('5', '123', '123');
INSERT INTO `student` VALUES ('6', '123', '1231');
INSERT INTO `student` VALUES ('7', '1', '2');
INSERT INTO `student` VALUES ('8', '3', '4');
INSERT INTO `student` VALUES ('9', '33', '44');
INSERT INTO `student` VALUES ('10', '45', 'dfg');
INSERT INTO `student` VALUES ('11', '22', 'hj');
INSERT INTO `student` VALUES ('12', '45', 'df');
INSERT INTO `student` VALUES ('13', 'ef', '33');
INSERT INTO `student` VALUES ('14', '234', 'hh');
INSERT INTO `student` VALUES ('15', 'trgq', '766');
INSERT INTO `student` VALUES ('16', 'cv3', '3e3');
INSERT INTO `student` VALUES ('17', '张三1', 'zhangsan@163.com');
INSERT INTO `student` VALUES ('18', '张三12', 'zhangsan@163.com');
INSERT INTO `student` VALUES ('19', '123', '123');
INSERT INTO `student` VALUES ('20', '1', '2');
INSERT INTO `student` VALUES ('21', '张三121', 'zhangsan@163.com');
INSERT INTO `student` VALUES ('22', '来了', 'zhangsan@163.com');
INSERT INTO `student` VALUES ('23', '张三121', 'zhangsan@163.com');
INSERT INTO `student` VALUES ('24', '123', '1231');
INSERT INTO `student` VALUES ('25', '123', 'zhangsan@163.com');
INSERT INTO `student` VALUES ('26', 'aab', 'aab');
