/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0.19
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : lab_check_sys

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 01/05/2021 18:20:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a_user
-- ----------------------------
DROP TABLE IF EXISTS `a_user`;
CREATE TABLE `a_user`  (
  `id` int(0) NOT NULL,
  `tea_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '教师id',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `appoint_time` datetime(0) NULL DEFAULT NULL COMMENT '任命时间',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id，一般只有管理员3，和超级管理员4两种',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dayoff_apply
-- ----------------------------
DROP TABLE IF EXISTS `dayoff_apply`;
CREATE TABLE `dayoff_apply`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'openid',
  `dayoff_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '请假时间，不连续多天请假表示为字符串',
  `contact` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系方式',
  `reason` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请假事由描述',
  `type` tinyint(0) NOT NULL COMMENT '请假类型，0事假，1病假',
  `apply_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '申请时间',
  `is_pass` tinyint(0) NOT NULL DEFAULT 2 COMMENT '是否通过,0不通过，1通过，2待批准',
  `pass_time` datetime(0) NULL DEFAULT NULL COMMENT '通过时间',
  `pass_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '批准申请的id，一般是当前实验室负责人的openid',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dayoff_apply
-- ----------------------------
INSERT INTO `dayoff_apply` VALUES (1, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-01', '18011108917', '测试元旦', 0, '2021-01-01 19:18:55', 2, '2021-01-01 19:18:59', '233333');
INSERT INTO `dayoff_apply` VALUES (2, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-06', '18011108917', '测试', 1, '2021-03-05 19:18:06', 1, '2021-03-05 19:18:13', '233333');
INSERT INTO `dayoff_apply` VALUES (3, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-09', '18011108917', '测试', 0, '2021-02-09 19:17:30', 0, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (4, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-10', '18011108917', '测试', 0, '2021-02-10 19:16:52', 0, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (5, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-11', '18011108917', '测试', 0, '2021-02-11 19:16:20', 0, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (6, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-12', '18011108917', '测试', 0, '2021-02-12 19:15:45', 0, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (7, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-01-15', '18011108917', '测试1', 0, '2021-01-14 17:15:52', 1, '2021-01-14 17:16:01', '233333');
INSERT INTO `dayoff_apply` VALUES (8, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-02-01,2021-02-02', '18011108917', '测试', 1, '2021-02-01 17:14:49', 0, '2021-02-01 17:15:01', '233333');
INSERT INTO `dayoff_apply` VALUES (9, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-02-09', '18011108917', '这是个测试数据，我请事假待批准', 0, '2021-03-05 15:36:13', 2, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (10, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-02-24', '18011108917', '这还是个测试数据，我也不想请假', 0, '2021-02-22 15:30:48', 0, '2021-02-23 15:31:02', '233333');
INSERT INTO `dayoff_apply` VALUES (11, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-03-03,2021-03-07', '18011108917', '我也不知道什么原因，这就是个测试而已。', 1, '2021-03-01 15:26:29', 1, '2021-03-02 15:26:47', '233333');
INSERT INTO `dayoff_apply` VALUES (12, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-03-21', '18011108917', '测试2', 0, '2021-03-21 19:40:33', 2, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (13, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-03-21,2021-03-22', '', '微信', 1, '2021-03-21 20:45:02', 2, NULL, NULL);
INSERT INTO `dayoff_apply` VALUES (14, 'o_t9X42WD-rF-MymTztUFieNOV-M', '2021-03-25,2021-03-26', '18011108917', '你猜', 0, '2021-03-23 15:20:46', 2, NULL, NULL);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生或老师的openid',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '反馈内容',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, '233333', '反馈的内容在这里最多500字', '2021-03-22 23:18:34');
INSERT INTO `feedback` VALUES (3, '233333', 'cs', '2021-03-23 15:28:35');
INSERT INTO `feedback` VALUES (5, 'o_t9X42WD-rF-MymTztUFieNOV-M', '来着微信的反馈', '2021-03-23 15:33:36');

-- ----------------------------
-- Table structure for global_data
-- ----------------------------
DROP TABLE IF EXISTS `global_data`;
CREATE TABLE `global_data`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_data
-- ----------------------------
INSERT INTO `global_data` VALUES ('appid', 'wxf0b3f4d6592571a9');
INSERT INTO `global_data` VALUES ('appsecret', '4153df76de8f96ea71cd951263504f1b');
INSERT INTO `global_data` VALUES ('code2Session', 'https://api.weixin.qq.com/sns/jscode2session');

-- ----------------------------
-- Table structure for lab
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '实验室无意义自增id',
  `lab_number` int(0) NULL DEFAULT NULL COMMENT '实验室号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '实验室名称(没有名称就用门牌号代替)',
  `room` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '门牌号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `seat` int(0) NULL DEFAULT NULL COMMENT '座位数量',
  `open_time` time(0) NULL DEFAULT NULL COMMENT '开放时间',
  `close_time` time(0) NULL DEFAULT NULL COMMENT '关闭时间',
  `should_checkin_time_a` time(0) NULL DEFAULT NULL COMMENT '规定开始签到',
  `should_checkin_time_b` time(0) NULL DEFAULT NULL COMMENT '规定签到结束',
  `should_checkout_time_a` time(0) NULL DEFAULT NULL COMMENT '规定开始签退',
  `should_checkout_time_b` time(0) NULL DEFAULT NULL COMMENT '规定结束签退',
  `basic_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '实验室文字介绍',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '实验室照片url',
  `rule_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '管理规则',
  `revise_time` date NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lab
-- ----------------------------
INSERT INTO `lab` VALUES (1, 101, '信息开发实验室', '101', '川师成龙校区第一实验楼', 12, '08:00:00', '18:00:00', '17:00:00', '17:00:00', '18:00:00', '18:30:00', 'xxx实验室成立于2016年，隶属于四川师范大学计算机科学学院，xxx配备有先进的xx设备，可以容纳20位学生行xx实验，这是乱写的乱写的乱写的乱写为实验人员提供xxx保障。', 'https://img.yzcdn.cn/vant/cat.jpeg', '1、进入实验室的所有人员，必须整洁、文明、肃静，必须遵守实验室的各项规章制\r\n度。 \r\n2、实验人员在实验过程中，要注意保持室内卫生及良好的实验习惯。实验结束后，必\r\n须及时做好清洁整理工作，实验人员必须将工作台、仪器设备、器皿等清洁干净，并将\r\n仪器设备和器皿按规定归类放好，不能随意放置。所有实验所产生的废物应及时放入废\r\n物箱内，并及时处理，清理好现场。 \r\n3、每次实验结束后，实验人员必须对实验室进行清扫。 \r\n4、实验室负责人需安排日常的卫生清扫。实验室成员有清扫实验室的义务。 \r\n5、实验室内各种设备、物品摆放要合理、整齐，与实验无关的物品禁止带入、存放在\r\n实验室。 \r\n6、实验室为保持室内地面、实验台、设备和工作环境的干净整洁，必须坚持每天一小\r\n扫，每周一大扫的卫生制度，每年彻底清扫1--2次。   \r\n7、实验室内的仪器设备、各人实验台架、凳和各种设施摆放整齐，并经常擦拭，保持\r\n无污渍、无灰尘。 \r\n8、卫生值日人员应对实验室桌面、地面及时打扫。注意保持室内仪器设备的整洁卫\r\n生。 \r\n9、实验室内杂物要清理干净，有机溶剂、腐蚀性液体的废液必须盛于废液桶内，贴上\r\n标签，统一回收处理。 \r\n10、保持室内地面无灰尘、无积水、无纸屑等垃圾。 ', '2021-03-21');

-- ----------------------------
-- Table structure for log_operate_record
-- ----------------------------
DROP TABLE IF EXISTS `log_operate_record`;
CREATE TABLE `log_operate_record`  (
  `id` int(0) NOT NULL,
  `request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `remote_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `reate_time` datetime(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `is_success` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '消息id 删除时串联删除相应的message_tag',
  `send_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送方的id（管理员通知是管理员的Id,实验室通知是老师的openid）',
  `lab_id` int(0) NULL DEFAULT NULL COMMENT '教师对实验室成员群体通知时有效',
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '消息标题',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '消息内容',
  `type` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '消息类型，0教师对实验室成员群体通知，1管理员全体通知，2管理员教师通知',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '233333', 1, '国庆放假通知', '这是国庆放假通知的内容，是系统管理员编辑的。这是国庆放假通知的内容，是系统管理员编辑的。这是国庆放假通知的内容，是系统管理员编辑的。', 0, '2021-03-22 13:56:21');
INSERT INTO `message` VALUES (2, '20101103', NULL, '管理员对全体师生的通知', '管理员对全体师生的通知', 1, '2021-03-20 14:09:21');
INSERT INTO `message` VALUES (3, '233333', 2, '老师对另一个实验室的通知', '老师对另一个实验室的通知', 0, '2021-03-22 14:10:22');
INSERT INTO `message` VALUES (4, '20101103', NULL, '管理员对老师的通知', '管理员对老师的通知', 2, '2021-03-22 14:11:01');

-- ----------------------------
-- Table structure for message_tag
-- ----------------------------
DROP TABLE IF EXISTS `message_tag`;
CREATE TABLE `message_tag`  (
  `message_id` int(0) NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`message_id`, `openid`) USING BTREE,
  CONSTRAINT `message_id` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_tag
-- ----------------------------
INSERT INTO `message_tag` VALUES (1, 'o_t9X42WD-rF-MymTztUFieNOV-M');
INSERT INTO `message_tag` VALUES (2, 'o_t9X42WD-rF-MymTztUFieNOV-M');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学生序列编号',
  `lab_id` int(0) NULL DEFAULT NULL COMMENT '实验室序列编号',
  `check_date` date NOT NULL COMMENT '签到日期',
  `checkin_time` time(0) NULL DEFAULT NULL COMMENT '签到时间',
  `checkout_time` time(0) NULL DEFAULT NULL COMMENT '签退时间',
  `checkin_loc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '签到地点',
  `checkout_loc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '签退地点',
  `status` tinyint(0) NULL DEFAULT -1 COMMENT '状态，0到勤(正常签到正常签退)，1缺席（未签到未签退），2迟到（未签到正常签退），3未签退（正常签到未签退），4请假',
  PRIMARY KEY (`openid`, `check_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('111111', 1, '2021-04-11', '16:19:08', NULL, 'www', NULL, 3);
INSERT INTO `record` VALUES ('121111', 2, '2021-03-07', '21:19:30', '21:19:32', NULL, NULL, 0);
INSERT INTO `record` VALUES ('121111', 2, '2021-03-20', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('121111', 2, '2021-03-22', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('122235', 1, '2021-03-04', '15:23:31', NULL, NULL, NULL, 3);
INSERT INTO `record` VALUES ('122235', 1, '2021-03-20', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('122235', 1, '2021-03-22', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('125421', 1, '2021-03-01', '12:14:17', '15:11:56', NULL, NULL, 0);
INSERT INTO `record` VALUES ('125421', 1, '2021-03-04', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('125421', 1, '2021-03-20', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('125421', 1, '2021-03-22', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-02-28', NULL, '15:23:52', NULL, NULL, 2);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-01', '15:10:51', '23:31:12', '四川省成都市成都环球中心天堂洲际大饭店', '四川省成都市成都环球中心天堂洲际大饭店', 0);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-02', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-03', '17:07:14', NULL, NULL, NULL, 3);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-04', '17:07:36', '17:07:55', NULL, NULL, 0);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-05', NULL, '17:08:11', NULL, NULL, 2);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-07', NULL, NULL, NULL, NULL, 4);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-19', '23:26:32', '23:26:34', NULL, NULL, 0);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-20', NULL, NULL, NULL, NULL, 1);
INSERT INTO `record` VALUES ('o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-03-22', NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for s_perms
-- ----------------------------
DROP TABLE IF EXISTS `s_perms`;
CREATE TABLE `s_perms`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_perms
-- ----------------------------
INSERT INTO `s_perms` VALUES (0, '微信登录', '/welogin', 'menu', 1);

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
  `id` int(0) UNSIGNED NOT NULL COMMENT '注销用户-1，未绑定学号普通学生0，未授权的负责老师1，已绑定学生2，已授权的老师3，管理员,4，超级管理员5',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述这个角色',
  `status` int(0) NULL DEFAULT NULL COMMENT '0关闭，1开启',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES (0, 'NotBind', '小程序端会进入绑定界面', 1);
INSERT INTO `s_role` VALUES (1, 'Student', '小程序进入学生界面', 1);
INSERT INTO `s_role` VALUES (2, 'Teacher', '小程序进入教师界面', 1);
INSERT INTO `s_role` VALUES (3, 'NotAuthentic', '未授权', 1);
INSERT INTO `s_role` VALUES (4, 'Admin', 'web端可登陆，但不能进行权限管理，日志查看，和删除操作', 1);
INSERT INTO `s_role` VALUES (5, 'SuperAdmin', '最高权限', 1);

-- ----------------------------
-- Table structure for s_role_perms
-- ----------------------------
DROP TABLE IF EXISTS `s_role_perms`;
CREATE TABLE `s_role_perms`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `perms_id` int(0) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role_perms
-- ----------------------------
INSERT INTO `s_role_perms` VALUES (1, 0, 0);
INSERT INTO `s_role_perms` VALUES (2, 1, 0);
INSERT INTO `s_role_perms` VALUES (3, 2, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学生编号，无具体意义，作为主键，递增',
  `stu_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生姓名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生性别，0代表女，1代表男',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
  `secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生学号密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '2017110323', '李其芳', '女', '18011108917', '计算机科学学院', '网络工程', '242384');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '教师编号，无具体意义，作为主键，递增',
  `tea_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '教师工号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '教师姓名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '0代表你,1代表男',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '教师工号密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '20101103', '张三', '男', NULL, '18732164561', '242384');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '微信openid',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '微信昵称',
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `stu_tea_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'teacher、student的id',
  `role_id` tinyint(0) NULL DEFAULT NULL COMMENT '角色id,0未绑定,1学生2,教师,3管理员,4超级管理员',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `latest_time` timestamp(0) NULL DEFAULT NULL COMMENT '最近登录',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `openid`(`openid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '233333', '张三', 'https://thirdwx.qlogo.cn/mmopen/vi_32/WUndm7hBa1EWLicC9c5qeEqeUkVGbwcYicXP8KSrEjfPI9Z3tMCmBW9prPBaB3wS9HdJQ5HM3iamzVwSIdDfdIAicg/132', NULL, '20101103', 2, '2021-03-21 22:10:31', NULL);
INSERT INTO `user` VALUES (2, 'o_t9X42WD-rF-MymTztUFieNOV-M', '星辰入袖', 'https://thirdwx.qlogo.cn/mmopen/vi_32/WUndm7hBa1EWLicC9c5qeEqeUkVGbwcYicXP8KSrEjfPI9Z3tMCmBW9prPBaB3wS9HdJQ5HM3iamzVwSIdDfdIAicg/132', NULL, '2017110323', 1, '2021-02-25 18:32:53', '2021-04-11 16:29:08');

-- ----------------------------
-- Table structure for user_lab
-- ----------------------------
DROP TABLE IF EXISTS `user_lab`;
CREATE TABLE `user_lab`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '所属实验室自增序列',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户openid',
  `lab_id` int(0) NULL DEFAULT NULL COMMENT '实验室id',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '加入时间',
  `status` tinyint(0) NULL DEFAULT 1 COMMENT '状态，0退出，1存在',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_lab
-- ----------------------------
INSERT INTO `user_lab` VALUES (1, 'o_t9X42WD-rF-MymTztUFieNOV-M', 1, '2021-02-26 10:58:39', 1);
INSERT INTO `user_lab` VALUES (2, '122235', 1, '2021-03-07 21:50:56', 1);
INSERT INTO `user_lab` VALUES (4, '125421', 1, '2021-03-07 21:52:15', 1);
INSERT INTO `user_lab` VALUES (5, '121111', 2, '2021-03-07 21:53:57', 1);

-- ----------------------------
-- Table structure for user_lab_tea
-- ----------------------------
DROP TABLE IF EXISTS `user_lab_tea`;
CREATE TABLE `user_lab_tea`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `lab_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` tinyint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_lab_tea
-- ----------------------------
INSERT INTO `user_lab_tea` VALUES (1, '233333', 1, '2021-03-21 15:29:08', 1);

-- ----------------------------
-- Triggers structure for table record
-- ----------------------------
DROP TRIGGER IF EXISTS `update_status_when_insert`;
delimiter ;;
CREATE TRIGGER `update_status_when_insert` BEFORE INSERT ON `record` FOR EACH ROW if (new.checkin_time is not null and new.checkout_time is null) then
	set new.status = 3;
elseif (new.checkin_time is null and new.checkout_time is not null) then
	set new.status = 2;
end if
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table record
-- ----------------------------
DROP TRIGGER IF EXISTS `update_status_when_update`;
delimiter ;;
CREATE TRIGGER `update_status_when_update` BEFORE UPDATE ON `record` FOR EACH ROW if (new.checkin_time is not null and new.checkout_time is null) then
	set new.status = 3;
elseif (new.checkin_time is null and new.checkout_time is not null) then
	set new.status = 2;
elseif (new.checkin_time is not null and new.checkout_time is not null) then
	set new.status = 0;
end if
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
