/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-11-10 17:37:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `login_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('784972358981328902', 'Tom', '24', 'rtt');
INSERT INTO `sys_user` VALUES ('784972358981328903', 'Jammy', '21', 'ww');
INSERT INTO `sys_user` VALUES ('796530029868236800', 'ssd', '22', 'gbvb');
INSERT INTO `sys_user` VALUES ('796643763420798976', 'gg', '44', null);

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `parent_id` int(11) DEFAULT NULL COMMENT '资源父id',
  `name` varchar(100) NOT NULL COMMENT '资源名称',
  `source_key` varchar(100) NOT NULL COMMENT '资源唯一标识',
  `type` int(11) NOT NULL COMMENT '资源类型,0:目录;1:菜单;2:按钮',
  `source_url` varchar(500) DEFAULT NULL COMMENT '资源url',
  `level` int(11) DEFAULT NULL COMMENT '层级',
  `icon` varchar(100) DEFAULT '' COMMENT '图标',
  `is_hide` int(11) DEFAULT '0' COMMENT '是否隐藏',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', null, '控制台', 'desktop', '0', '/welcome.jsp', '1', 'fa fa-tachometer', '0', '控制台', '2016-01-12 17:08:55', '2016-02-25 14:07:48');
INSERT INTO `tb_menu` VALUES ('2', null, '系统基础管理', 'system', '0', '', '1', 'fa fa-list', '0', '系统基础管理', '2016-01-05 12:11:12', '2016-02-25 14:07:48');
INSERT INTO `tb_menu` VALUES ('3', '2', '用户管理', 'system:user', '0', '/user/listUI.html', '2', '', '0', '用户管理', '2016-01-08 12:37:10', '2016-06-30 20:53:36');
INSERT INTO `tb_menu` VALUES ('4', '2', '角色管理', 'system:role', '0', '/role/listUI.html', '2', '', '0', '角色管理', '2016-01-11 22:51:07', '2016-06-30 20:53:38');
INSERT INTO `tb_menu` VALUES ('5', '2', '资源管理', 'system:resource', '0', '/resource/listUI.html', '2', '', '0', '资源管理', '2016-01-11 22:51:55', '2016-06-30 20:53:40');
INSERT INTO `tb_menu` VALUES ('6', null, '系统监控管理', 'monitor', '0', '', '1', 'fa fa-pencil-square-o', '0', '系统监控管理', '2016-01-05 12:11:12', '2016-02-25 14:07:48');
INSERT INTO `tb_menu` VALUES ('7', '6', 'Sirona监控', 'monitor:sirona', '0', '/sirona', '2', '', '0', 'Sirona监控', '2016-01-05 12:11:12', '2016-06-30 20:53:41');
INSERT INTO `tb_menu` VALUES ('8', '6', 'Druid监控', 'monitor:druid', '0', '/druid', '2', '', '0', 'Druid监控', '2016-01-11 22:45:27', '2016-06-30 20:53:44');
INSERT INTO `tb_menu` VALUES ('9', null, '日志信息管理', 'logininfo', '0', '', '1', 'fa fa-tag', '0', '日志信息管理', '2016-01-11 22:46:39', '2016-02-25 14:07:48');
INSERT INTO `tb_menu` VALUES ('10', '9', '用户登录信息', 'logininfo:userLogin', '0', '/loginInfo/listUI.html', '2', '', '0', '用户登录信息', '2016-01-11 22:47:41', '2016-02-25 14:07:48');
INSERT INTO `tb_menu` VALUES ('11', '3', '添加', 'user:add', '1', '/user/add.html', '3', null, '0', '添加用户', '2016-01-22 00:18:40', '2016-11-03 17:18:50');
INSERT INTO `tb_menu` VALUES ('12', '3', '编辑', 'user:edit', '1', '/user/edit.html', '3', null, '0', '编辑用户', '2016-01-22 00:18:40', '2016-10-27 11:35:27');
INSERT INTO `tb_menu` VALUES ('13', '3', '删除', 'user:deleteBatch', '1', '/user/deleteBatch.html', null, null, '0', '删除用户', '2016-02-05 15:26:32', '2016-06-30 20:54:44');
INSERT INTO `tb_menu` VALUES ('14', '3', '重置密码', 'user:resetPassword', '1', '/user/resetPassword.html', null, null, '0', '重置密码', '2016-02-27 23:55:13', '2016-06-30 20:54:45');
INSERT INTO `tb_menu` VALUES ('15', '4', '添加', 'role:add', '1', '/role/add.html', null, null, '0', '添加', '2016-02-27 23:56:52', '2016-06-30 20:54:46');
INSERT INTO `tb_menu` VALUES ('16', '4', '编辑', 'role:edit', '1', '/role/edit.html', null, null, '0', '编辑', '2016-02-27 23:57:35', '2016-06-30 20:54:47');
INSERT INTO `tb_menu` VALUES ('17', '4', '删除', 'role:deleteBatch', '1', '/role/deleteBatch.html ', null, null, '0', '删除', '2016-02-27 23:58:02', '2016-06-30 20:54:48');
INSERT INTO `tb_menu` VALUES ('18', '4', '分配权限', 'role:permission', '1', '/role/permission.html', null, null, '0', '分配权限', '2016-02-27 23:59:20', '2016-06-30 20:54:48');
INSERT INTO `tb_menu` VALUES ('19', '5', '添加', 'resource:add', '1', '/resource/add.html', null, null, '0', '添加', '2016-02-28 00:01:15', '2016-06-30 20:54:49');
INSERT INTO `tb_menu` VALUES ('20', '5', '编辑', 'resource:edit', '1', '/resource/edit.html', null, null, '0', '编辑', '2016-02-28 00:02:01', '2016-06-30 20:54:50');
INSERT INTO `tb_menu` VALUES ('21', '5', '删除', 'resource:deleteBatch', '1', '/resource/deleteBatch.html', null, null, '0', '删除', '2016-02-28 00:03:03', '2016-06-30 20:54:51');
INSERT INTO `tb_menu` VALUES ('22', '9', '用户操作信息', 'loginfo:userOperation', '0', '/logInfo/listUI.html', null, 'fa  fa-sticky-note-o', '0', '用户操作信息', '2016-03-08 22:00:36', '2016-07-01 16:14:54');
INSERT INTO `tb_menu` VALUES ('24', null, '一级菜单', 'menu', '0', '', null, 'fa  fa-asterisk', '0', '一级菜单', '2016-06-30 19:51:57', '2016-06-30 19:51:57');
INSERT INTO `tb_menu` VALUES ('25', '24', '二级菜单', 'menu:menu1', '0', '', null, '', '0', '二级菜单', '2016-06-30 19:54:01', '2016-06-30 21:03:49');
INSERT INTO `tb_menu` VALUES ('26', '25', '三级菜单', 'menu:menu1:menu2', '0', '', null, 'fa  fa-cloud-download', '0', '三级菜单', '2016-06-30 19:54:29', '2016-07-01 10:26:48');
INSERT INTO `tb_menu` VALUES ('27', '26', '四级菜单', 'menu:menu1:menu2:menu3', '0', '/logInfo/listUI.html', null, 'fa  fa-line-chart', '0', '四级菜单', '2016-06-30 19:55:53', '2016-07-01 11:17:38');
INSERT INTO `tb_menu` VALUES ('28', '25', '三级菜单1', 'menu:menu1:menu21', '0', '/logInfo/listUI.html', null, 'fa  fa-balance-scale', '0', '三级菜单1', '2016-06-30 20:16:44', '2016-07-01 16:37:53');
INSERT INTO `tb_menu` VALUES ('29', '24', '二级菜单1', 'menu:menu11', '0', '/logInfo/listUI.html', null, 'fa  fa-comment', '0', '二级菜单1', '2016-07-01 15:41:44', '2016-07-01 15:42:05');
INSERT INTO `tb_menu` VALUES ('30', '1', '11', '11', '0', '111', null, 'fa  fa-bug', '0', '', '2016-11-01 11:56:16', '2016-11-01 11:56:16');
INSERT INTO `tb_menu` VALUES ('31', null, '22', '22', '0', '22', null, 'fa  fa-camera-retro', '0', '', '2016-11-01 11:56:35', '2016-11-01 11:56:35');
INSERT INTO `tb_menu` VALUES ('32', '1', 'da', 'ASSA', '0', 'sAs', null, 'fa  fa-ban', '0', 'tty', '2016-11-03 15:41:40', '2016-11-04 12:00:02');
INSERT INTO `tb_menu` VALUES ('33', null, '1qqw', 'ww', '1', 'ww', null, 'fa  fa-battery-0', '0', '', '2016-11-04 14:48:23', '2016-11-04 14:48:22');