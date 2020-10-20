/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : power

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 20/10/2020 18:52:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字段注释',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '名称',
  `chinese_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `is_commonly_used` tinyint unsigned NOT NULL COMMENT '是否常用',
  `order_code` bigint(0) NULL DEFAULT NULL,
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人id',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint unsigned NOT NULL COMMENT '是否删除',
  `create_org_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人组织机构id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 370 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (1, '男', '8adcf7c96a48fae4016a4925e34b', 'dict_sex', '性别', 0, 1, '1', '2019-04-23 07:43:01', '1', '2019-05-14 07:39:29', 0, '1000');
INSERT INTO `dictionary` VALUES (2, '女', '8adcf7c96a48fae4016a4925e43f', 'dict_sex', '性别', 0, 2, '1', '2019-04-23 07:43:01', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (3, '未婚', '8adcf7c96a48fae4016a4925e47f', 'dict_marriage', '婚姻状况', 0, 1, '1', '2019-04-23 07:43:01', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (4, '已婚', '8adcf7c96a48fae4016a4925e570', 'dict_marriage', '婚姻状况', 0, 2, '1', '2019-04-23 07:43:01', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (5, '丧偶', '8adcf7c96a48fae4016a4925e5ae', 'dict_marriage', '婚姻状况', 0, 3, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (6, '离婚', '8adcf7c96a48fae4016a4925e676', 'dict_marriage', '婚姻状况', 0, 4, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (7, '再婚', '8adcf7c96a48fae4016a4925e6b0', 'dict_marriage', '婚姻状况', 0, 5, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (8, '独居', '8adcf7c96a48fae4016a4925e79d', 'dict_live_statu', '居住状况', 0, 1, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (9, '空巢', '8adcf7c96a48fae4016a4925e817', 'dict_live_statu', '居住状况', 0, 2, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (10, '与子女同住', '8adcf7c96a48fae4016a4925e8ff', 'dict_live_statu', '居住状况', 0, 3, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (11, '与保姆同住', '8adcf7c96a48fae4016a4925e930', 'dict_live_statu', '居住状况', 0, 4, '1', '2019-04-23 07:43:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (21, '党总支', '8adcf7c96a48fae4016a4925ee76', 'dict_party_type', '党组织类型', 0, 1, '1', '2019-04-23 07:43:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (22, '党工委', '8adcf7c96a48fae4016a4925ef63', 'dict_party_type', '党组织类型', 0, 2, '1', '2019-04-23 07:43:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (23, '党支部', '8adcf7c96a48fae4016a4925ef9d', 'dict_party_type', '党组织类型', 0, 3, '1', '2019-04-23 07:43:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (24, '党小组', '8adcf7c96a48fae4016a4925f065', 'dict_party_type', '党组织类型', 0, 4, '1', '2019-04-23 07:43:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (25, '总队', '8adcf7c96a48fae4016a4925f0a6', 'dict_volunteer_type', '志愿队类型', 0, 1, '1', '2019-04-23 07:43:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (26, '中队', 'dict_unit_nature', 'dict_volunteer_type', '志愿队类型', 0, 2, '1', '2019-04-23 07:43:05', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (27, '小队', '8adcf7c96a48fae4016a4925f1d2', 'dict_volunteer_type', '志愿队类型', 0, 3, '1', '2019-04-23 07:43:05', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (28, '中共党员', '8adcf7c96a48fae4016a4925f283', 'dict_political_status', '政治面貌', 0, 1, '1', '2019-04-23 07:43:05', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (29, '预备党员', '8adcf7c96a48fae4016a4925f2b7', 'dict_political_status', '政治面貌', 0, 2, '1', '2019-04-23 07:43:05', '1', '2019-08-05 23:02:21', 0, '1000');
INSERT INTO `dictionary` VALUES (31, '行政', '8adcf7c96a48fae4016a4925f3e3', 'dict_organization_type', '单位性质', 0, 2, '1', '2019-04-23 07:43:05', '1', '2019-07-31 16:38:07', 0, '1000');
INSERT INTO `dictionary` VALUES (32, '事业', '8adcf7c96a48fae4016a4925f4d8', 'dict_organization_type', '单位性质', 0, 3, '1', '2019-04-23 07:43:05', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (33, '企业', '8adcf7c96a48fae4016a4925f50a', 'dict_organization_type', '单位性质', 0, 4, '1', '2019-04-23 07:43:05', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (34, '离休', '8adcf7c96a48fae4016a4925f601', 'dict_retirement_type', '退(离休)类型', 0, 1, '1', '2019-04-23 07:43:06', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (35, '退休', '8adcf7c96a48fae4016a4925f63a', 'dict_retirement_type', '退(离休)类型', 0, 2, '1', '2019-04-23 07:43:06', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (36, '正省(部)级', '8adcf7c96a48fae4016a4925f71e', 'dict_retirement_level', '退（离）休时职级', 0, 1, '1', '2019-04-23 07:43:06', '1', '2019-08-12 20:58:12', 0, '1000');
INSERT INTO `dictionary` VALUES (37, '副省(部)级', '8adcf7c96a48fae4016a4925f750', 'dict_retirement_level', '退（离）休时职级', 0, 2, '1', '2019-04-23 07:43:06', '1', '2019-08-12 20:58:18', 0, '1000');
INSERT INTO `dictionary` VALUES (40, '正地（局）级', '8adcf7c96a48fae4016a4925f973', 'dict_retirement_level', '退（离）休时职级', 0, 5, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:58:27', 0, '1000');
INSERT INTO `dictionary` VALUES (41, '副地（局）级', '8adcf7c96a48fae4016a4925f9a3', 'dict_retirement_level', '退（离）休时职级', 0, 6, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:58:32', 0, '1000');
INSERT INTO `dictionary` VALUES (42, '正县(处)级', '8adcf7c96a48fae4016a4925fa8a', 'dict_retirement_level', '退（离）休时职级', 0, 7, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:58:37', 0, '1000');
INSERT INTO `dictionary` VALUES (43, '副县(处)级', '8adcf7c96a48fae4016a4925fabf', 'dict_retirement_level', '退（离）休时职级', 0, 8, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:58:42', 0, '1000');
INSERT INTO `dictionary` VALUES (44, '正乡(科)级', '8adcf7c96a48fae4016a4925fbad', 'dict_retirement_level', '退（离）休时职级', 0, 9, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:58:49', 0, '1000');
INSERT INTO `dictionary` VALUES (45, '副乡(科)级', '8adcf7c96a48fae4016a4925fbe6', 'dict_retirement_level', '退（离）休时职级', 0, 10, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:58:56', 0, '1000');
INSERT INTO `dictionary` VALUES (46, '正省(部)级待遇', '8adcf7c96a48fae4016a4925fcdb', 'dict_treatment_now', '现享受待遇', 0, 1, '1', '2019-04-23 07:43:07', '1', '2019-08-12 20:51:06', 0, '1000');
INSERT INTO `dictionary` VALUES (47, '副省(部)级待遇', '8adcf7c96a48fae4016a4925fd1b', 'dict_treatment_now', '现享受待遇', 0, 2, '1', '2019-04-23 07:43:08', '1', '2019-08-12 20:51:14', 0, '1000');
INSERT INTO `dictionary` VALUES (51, '正地（局）级待遇', '8adcf7c96a48fae4016a4925ff3c', 'dict_treatment_now', '现享受待遇', 0, 6, '1', '2019-04-23 07:43:08', '1', '2019-08-12 20:51:54', 0, '1000');
INSERT INTO `dictionary` VALUES (52, '副地（局）级待遇', '8adcf7c96a48fae4016a4926003c', 'dict_treatment_now', '现享受待遇', 0, 7, '1', '2019-04-23 07:43:08', '1', '2019-08-12 20:52:03', 0, '1000');
INSERT INTO `dictionary` VALUES (53, '正县(处)级待遇', '8adcf7c96a48fae4016a4926007f', 'dict_treatment_now', '现享受待遇', 0, 8, '1', '2019-04-23 07:43:08', '1', '2019-08-12 20:52:14', 0, '1000');
INSERT INTO `dictionary` VALUES (54, '副县(处)级待遇', '8adcf7c96a48fae4016a49260165', 'dict_treatment_now', '现享受待遇', 0, 9, '1', '2019-04-23 07:43:09', '1', '2019-08-12 20:52:20', 0, '1000');
INSERT INTO `dictionary` VALUES (55, '正乡(科)级待遇', '8adcf7c96a48fae4016a49260196', 'dict_treatment_now', '现享受待遇', 0, 10, '1', '2019-04-23 07:43:09', '1', '2019-08-12 20:52:31', 0, '1000');
INSERT INTO `dictionary` VALUES (56, '第一次国内革命战争', '8adcf7c96a48fae4016a492602ad', 'dict_revolution_period', '参加革命工作时间', 0, 1, '1', '2019-04-23 07:43:09', '1', '2019-07-31 15:48:44', 0, '1000');
INSERT INTO `dictionary` VALUES (57, '第二次国内革命战争', '8adcf7c96a48fae4016a492602df', 'dict_revolution_period', '参加革命工作时间', 0, 2, '1', '2019-04-23 07:43:09', '1', '2019-07-31 15:48:52', 0, '1000');
INSERT INTO `dictionary` VALUES (58, '抗日战争前期', '8adcf7c96a48fae4016a492603c4', 'dict_revolution_period', '参加革命工作时间', 0, 3, '1', '2019-04-23 07:43:09', '1', '2019-07-31 15:49:00', 0, '1000');
INSERT INTO `dictionary` VALUES (59, '抗日战争后期', '8adcf7c96a48fae4016a492603f3', 'dict_revolution_period', '参加革命工作时间', 0, 4, '1', '2019-04-23 07:43:09', '1', '2019-07-31 15:49:07', 0, '1000');
INSERT INTO `dictionary` VALUES (60, '解放战争时期', '8adcf7c96a48fae4016a492604e6', 'dict_revolution_period', '参加革命工作时间', 0, 5, '1', '2019-04-23 07:43:10', '1', '2019-07-31 15:49:15', 0, '1000');
INSERT INTO `dictionary` VALUES (61, '健康', '8adcf7c96a48fae4016a49260516', 'dict_health_status', '健康状况', 0, 1, '1', '2019-04-23 07:43:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (62, '一般', '8adcf7c96a48fae4016a492605fb', 'dict_health_status', '健康状况', 0, 2, '1', '2019-04-23 07:43:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (65, '汉族', '8adcf7c96a48fae4016a49260741', 'dict_nation', '民族', 0, 1, '1', '2019-04-23 07:43:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (66, '蒙古族', '8adcf7c96a48fae4016a4926084a', 'dict_nation', '民族', 0, 2, '1', '2019-04-23 07:43:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (67, '满族', '8adcf7c96a48fae4016a4926087a', 'dict_nation', '民族', 0, 3, '1', '2019-04-23 07:43:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (68, '朝鲜族', '8adcf7c96a48fae4016a4926097a', 'dict_nation', '民族', 0, 4, '1', '2019-04-23 07:43:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (69, '赫哲族', '8adcf7c96a48fae4016a492609a7', 'dict_nation', '民族', 0, 5, '1', '2019-04-23 07:43:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (70, '达斡尔族', '8adcf7c96a48fae4016a49260aa0', 'dict_nation', '民族', 0, 6, '1', '2019-04-23 07:43:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (71, '鄂温克族', '8adcf7c96a48fae4016a49260ad5', 'dict_nation', '民族', 0, 7, '1', '2019-04-23 07:43:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (72, '鄂伦春族', '8adcf7c96a48fae4016a49260be2', 'dict_nation', '民族', 0, 8, '1', '2019-04-23 07:43:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (73, '回族', '8adcf7c96a48fae4016a49260c20', 'dict_nation', '民族', 0, 9, '1', '2019-04-23 07:43:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (74, '东乡族', '8adcf7c96a48fae4016a49260d1a', 'dict_nation', '民族', 0, 10, '1', '2019-04-23 07:43:12', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (75, '土族', '8adcf7c96a48fae4016a49260d55', 'dict_nation', '民族', 0, 11, '1', '2019-04-23 07:43:12', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (76, '撒拉族', '8adcf7c96a48fae4016a49260e48', 'dict_nation', '民族', 0, 12, '1', '2019-04-23 07:43:12', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (77, '保安族', '8adcf7c96a48fae4016a49260e8b', 'dict_nation', '民族', 0, 13, '1', '2019-04-23 07:43:12', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (78, '裕固族', '8adcf7c96a48fae4016a49260f75', 'dict_nation', '民族', 0, 14, '1', '2019-04-23 07:43:12', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (79, '维吾尔族', '8adcf7c96a48fae4016a49260fb2', 'dict_nation', '民族', 0, 15, '1', '2019-04-23 07:43:12', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (80, '哈萨克族', '8adcf7c96a48fae4016a492610a7', 'dict_nation', '民族', 0, 16, '1', '2019-04-23 07:43:13', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (81, '柯尔克孜族', '8adcf7c96a48fae4016a492610de', 'dict_nation', '民族', 0, 17, '1', '2019-04-23 07:43:13', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (82, '锡伯族', '8adcf7c96a48fae4016a492611df', 'dict_nation', '民族', 0, 18, '1', '2019-04-23 07:43:13', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (83, '塔吉克族', '8adcf7c96a48fae4016a49261219', 'dict_nation', '民族', 0, 19, '1', '2019-04-23 07:43:13', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (84, '乌孜别克族', '8adcf7c96a48fae4016a49261312', 'dict_nation', '民族', 0, 20, '1', '2019-04-23 07:43:13', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (85, '俄罗斯族', '8adcf7c96a48fae4016a49261344', 'dict_nation', '民族', 0, 21, '1', '2019-04-23 07:43:13', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (86, '塔塔尔族', '8adcf7c96a48fae4016a4926145d', 'dict_nation', '民族', 0, 22, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (87, '藏族', '8adcf7c96a48fae4016a492614d4', 'dict_nation', '民族', 0, 23, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (88, '门巴族', '8adcf7c96a48fae4016a492615a7', 'dict_nation', '民族', 0, 24, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (89, '珞巴族', '8adcf7c96a48fae4016a492615d9', 'dict_nation', '民族', 0, 25, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (90, '羌族', '8adcf7c96a48fae4016a4926167f', 'dict_nation', '民族', 0, 26, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (91, '彝族', '8adcf7c96a48fae4016a492616b5', 'dict_nation', '民族', 0, 27, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (92, '白族', '8adcf7c96a48fae4016a49261797', 'dict_nation', '民族', 0, 28, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (93, '哈尼族', '8adcf7c96a48fae4016a492617c9', 'dict_nation', '民族', 0, 29, '1', '2019-04-23 07:43:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (94, '傣族', '8adcf7c96a48fae4016a4926186e', 'dict_nation', '民族', 0, 30, '1', '2019-04-23 07:43:15', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (95, '僳僳族', '8adcf7c96a48fae4016a4926189d', 'dict_nation', '民族', 0, 31, '1', '2019-04-23 07:43:15', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (96, '佤族', '8adcf7c96a48fae4016a492619da', 'dict_nation', '民族', 0, 32, '1', '2019-04-23 07:43:15', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (97, '拉祜族', '8adcf7c96a48fae4016a49261a11', 'dict_nation', '民族', 0, 33, '1', '2019-04-23 07:43:15', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (98, '纳西族', '8adcf7c96a48fae4016a49261b21', 'dict_nation', '民族', 0, 34, '1', '2019-04-23 07:43:15', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (99, '景颇族', '8adcf7c96a48fae4016a49262218', 'dict_nation', '民族', 0, 35, '1', '2019-04-23 07:43:17', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (100, '布朗族', '8adcf7c96a48fae4016a492622a1', 'dict_nation', '民族', 0, 36, '1', '2019-04-23 07:43:17', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (101, '阿昌族', '8adcf7c96a48fae4016a49262339', 'dict_nation', '民族', 0, 37, '1', '2019-04-23 07:43:17', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (102, '普米族', '8adcf7c96a48fae4016a492623c6', 'dict_nation', '民族', 0, 38, '1', '2019-04-23 07:43:17', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (103, '怒族', '8adcf7c96a48fae4016a49262457', 'dict_nation', '民族', 0, 39, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (104, '德昂族', '8adcf7c96a48fae4016a492624e7', 'dict_nation', '民族', 0, 40, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (105, '独龙族', '8adcf7c96a48fae4016a4926256f', 'dict_nation', '民族', 0, 41, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (106, '基诺族', '8adcf7c96a48fae4016a49262603', 'dict_nation', '民族', 0, 42, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (107, '苗族', '8adcf7c96a48fae4016a49262697', 'dict_nation', '民族', 0, 43, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (108, '布依族', '8adcf7c96a48fae4016a49262728', 'dict_nation', '民族', 0, 44, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (109, '侗族', '8adcf7c96a48fae4016a492627d4', 'dict_nation', '民族', 0, 45, '1', '2019-04-23 07:43:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (110, '水族', '8adcf7c96a48fae4016a49262868', 'dict_nation', '民族', 0, 46, '1', '2019-04-23 07:43:19', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (111, '仡佬族', '8adcf7c96a48fae4016a492628f9', 'dict_nation', '民族', 0, 47, '1', '2019-04-23 07:43:19', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (112, '壮族', '8adcf7c96a48fae4016a49262998', 'dict_nation', '民族', 0, 48, '1', '2019-04-23 07:43:19', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (113, '瑶族', '8adcf7c96a48fae4016a49262a56', 'dict_nation', '民族', 0, 49, '1', '2019-04-23 07:43:19', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (114, '仫佬族', '8adcf7c96a48fae4016a49262ae4', 'dict_nation', '民族', 0, 50, '1', '2019-04-23 07:43:19', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (115, '毛南族', '8adcf7c96a48fae4016a49262b88', 'dict_nation', '民族', 0, 51, '1', '2019-04-23 07:43:19', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (116, '京族', '8adcf7c96a48fae4016a49262c21', 'dict_nation', '民族', 0, 52, '1', '2019-04-23 07:43:20', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (117, '土家族', '8adcf7c96a48fae4016a49262ca3', 'dict_nation', '民族', 0, 53, '1', '2019-04-23 07:43:20', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (118, '黎族', '8adcf7c96a48fae4016a49262d52', 'dict_nation', '民族', 0, 54, '1', '2019-04-23 07:43:20', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (119, '畲族', '8adcf7c96a48fae4016a49262ded', 'dict_nation', '民族', 0, 55, '1', '2019-04-23 07:43:20', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (120, '高山族', '8adcf7c96a48fae4016a49262e8a', 'dict_nation', '民族', 0, 56, '1', '2019-04-23 07:43:20', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (123, '第一季度', '8adcf7c96a48fae4016a49263041', 'dict_quarter', '季度', 0, 1, '1', '2019-04-23 07:43:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (124, '第二季度', '8adcf7c96a48fae4016a492630ea', 'dict_quarter', '季度', 0, 2, '1', '2019-04-23 07:43:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (125, '第三季度', '8adcf7c96a48fae4016a49263186', 'dict_quarter', '季度', 0, 3, '1', '2019-04-23 07:43:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (126, '第四季度', '8adcf7c96a48fae4016a49263233', 'dict_quarter', '季度', 0, 4, '1', '2019-04-23 07:43:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (127, '在职', '8adcf7c96a48fae4016a492632d6', 'dict_now_state', '目前状况', 0, 1, '1', '2019-04-23 07:43:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (128, '退休', '8adcf7c96a48fae4016a49263371', 'dict_now_state', '目前状况', 0, 2, '1', '2019-04-23 07:43:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (129, '离休', '8adcf7c96a48fae4016a4926343c', 'dict_now_state', '目前状况', 0, 3, '1', '2019-04-23 07:43:22', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (130, '无职业', '8adcf7c96a48fae4016a492634be', 'dict_now_state', '目前状况', 0, 4, '1', '2019-04-23 07:43:22', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (131, '离世', '8adcf7c96a48fae4016a49263568', 'dict_now_state', '目前状况', 0, 5, '1', '2019-04-23 07:43:22', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (132, '其他', '8adcf7c96a48fae4016a49263606', 'dict_now_state', '目前状况', 0, 6, '1', '2019-04-23 07:43:22', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (135, '退休', '8adcf7c96a48fae4016a49263866', 'dict_treatment_now', '现享受待遇', 0, 11, '1', '2019-04-23 07:43:23', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (136, '离休', '8adcf7c96a48fae4016a49263942', 'dict_treatment_now', '现享受待遇', 0, 12, '1', '2019-04-23 07:43:23', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (139, '生日祝福', '8adcf7c96a48fae4016a49263b25', 'dict_message_type', '短信模板类型', 0, 2, '1', '2019-04-23 07:43:23', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (140, '元旦祝福', '8adcf7c96a48fae4016a49263bd5', 'dict_message_type', '短信模板类型', 0, 3, '1', '2019-04-23 07:43:24', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (141, '春节祝福', '8adcf7c96a48fae4016a49263c80', 'dict_message_type', '短信模板类型', 0, 4, '1', '2019-04-23 07:43:24', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (143, '劳动节祝福', '8adcf7c96a48fae4016a49263db0', 'dict_message_type', '短信模板类型', 0, 6, '1', '2019-04-23 07:43:24', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (144, '端午节祝福', '8adcf7c96a48fae4016a49263eab', 'dict_message_type', '短信模板类型', 0, 7, '1', '2019-04-23 07:43:24', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (146, '中秋节祝福', '8adcf7c96a48fae4016a49263fdb', 'dict_message_type', '短信模板类型', 0, 9, '1', '2019-04-23 07:43:25', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (148, '国庆节祝福', '8adcf7c96a48fae4016a492640d7', 'dict_message_type', '短信模板类型', 0, 11, '1', '2019-04-23 07:43:25', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (150, '生活自理', '8adcf7c96a48fae4016a49264215', 'action', '活动能力', 0, 1, '1', '2019-04-23 07:43:25', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (151, '生活不能自理', '8adcf7c96a48fae4016a492642a2', 'action', '活动能力', 0, 2, '1', '2019-04-23 07:43:25', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (152, '其他', '8adcf7c96a48fae4016a49264337', 'dict_retirement_level', '退（离）休时职级', 0, 14, '1', '2019-04-23 07:43:25', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (174, '一级甲等', '8adcf7dd6ac4dd9e016ac4f81df2', 'dict_hospital_level', '医院级别', 0, 1, '1', '2019-05-17 08:45:56', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (175, '一级乙等', '8adcf7dd6ac4dd9e016ac4f87510', 'dict_hospital_level', '医院级别', 0, 2, '1', '2019-05-17 08:46:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (176, '一级丙等', '8adcf7dd6ac4dd9e016ac4f8ba4b', 'dict_hospital_level', '医院级别', 0, 3, '1', '2019-05-17 08:46:36', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (177, '二级甲等', '8adcf7dd6ac4dd9e016ac4f8e617', 'dict_hospital_level', '医院级别', 0, 4, '1', '2019-05-17 08:46:47', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (178, '二级乙等', '8adcf7dd6ac4dd9e016ac4f914fa', 'dict_hospital_level', '医院级别', 0, 5, '1', '2019-05-17 08:46:59', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (179, '二级丙等', '8adcf7dd6ac4dd9e016ac4f94e35', 'dict_hospital_level', '医院级别', 0, 6, '1', '2019-05-17 08:47:14', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (180, '三级甲等', '8adcf7dd6ac4dd9e016ac4f97edf', 'dict_hospital_level', '医院级别', 0, 7, '1', '2019-05-17 08:47:26', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (181, '三级乙等', '8adcf7dd6ac4dd9e016ac4f9b043', 'dict_hospital_level', '医院级别', 0, 8, '1', '2019-05-17 08:47:39', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (182, '三级丙等', '8adcf7dd6ac4dd9e016ac4f9d488', 'dict_hospital_level', '医院级别', 0, 9, '1', '2019-05-17 08:47:48', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (183, '公立', '8adcf7dd6ac4dd9e016ac51318e6', 'dict_hospital_nature', '医院性质', 0, 1, '1', '2019-05-17 09:15:24', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (184, '民营', '8adcf7dd6ac4dd9e016ac5137622', 'dict_hospital_nature', '医院性质', 0, 2, '1', '2019-05-17 09:15:48', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (185, '家庭变故', '8adcf7dd6ac4dd9e016ac519003c', 'dict_help_reason', '帮扶原因', 0, 1, '1', '2019-05-17 09:21:51', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (186, '重大疾病', '8adcf7dd6ac4dd9e016ac5193091', 'dict_help_reason', '帮扶原因', 0, 1, '1', '2019-05-17 09:22:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (187, '特殊补助', '8adcf7dd6ac4dd9e016ac51964b2', 'dict_help_reason', '帮扶原因', 0, 1, '1', '2019-05-17 09:22:17', '1', '2019-06-26 15:45:03', 0, '1000');
INSERT INTO `dictionary` VALUES (191, '副省部级医疗待遇', '828085c56aded154016aded8d789', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-22 09:21:54', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (192, '按副省部级报销医疗费', '828085c56aded154016aded907eb', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-22 09:22:06', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (195, '参加', '8adcf7df6ae48227016ae4822769', 'dict_attendance', '出勤记录', 0, 1, '1', '2019-05-23 11:44:56', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (196, '缺勤', '8adcf7df6ae48227016ae4825b17', 'dict_attendance', '出勤记录', 0, 2, '1', '2019-05-23 11:45:09', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (200, '行政', '8adcf7df6afc354a016afc354a83', 'dict_unit_nature', '单位属性', 0, 1, '1', '2019-05-28 02:11:52', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (201, '事业', '8adcf7df6afc354a016afc356c0a', 'dict_unit_nature', '单位属性', 0, 2, '1', '2019-05-28 02:12:01', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (202, '企业', '8adcf7df6afc354a016afc358fa2', 'dict_unit_nature', '单位属性', 0, 3, '1', '2019-05-28 02:12:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (203, '标准支部', '8afc05406b01a359016b01a35971', 'dict_party_category', '支部类别', 0, 1, '1', '2019-05-29 03:30:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (204, '多单位联合支部', '8afc05406b01a359016b01a3a36e', 'dict_party_category', '支部类别', 0, 1, '1', '2019-05-29 03:30:30', '1', '2019-06-28 18:05:06', 0, '1000');
INSERT INTO `dictionary` VALUES (205, '在职离退人员混编支部', '8afc05406b01a359016b01a3ea0b', 'dict_party_category', '支部类别', 0, 1, '1', '2019-05-29 03:30:48', '1', '2019-06-28 18:05:06', 0, '1000');
INSERT INTO `dictionary` VALUES (206, '临时支部', '8afc05406b01a359016b01a5930f', 'dict_party_category', '支部类别', 0, 1, '1', '2019-05-29 03:32:37', '1', '2019-06-28 18:05:06', 0, '1000');
INSERT INTO `dictionary` VALUES (207, '正厅局级医疗待遇', '8adcf7c96b0845f3016b0852b878', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-30 10:39:27', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (208, '按正厅局级报销医疗费', '8adcf7c96b0845f3016b0852e595', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-30 10:39:39', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (209, '副厅局级医疗待遇', '8adcf7c96b0845f3016b08530e9e', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-30 10:39:49', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (210, '按副厅局级报销医疗费', '8adcf7c96b0845f3016b08533b40', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-30 10:40:01', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (211, '市局保健对象', '8adcf7c96b0845f3016b08537f41', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-30 10:40:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (212, '其他', '8adcf7c96b0845f3016b0853a5ae', 'dict_medical_treatment', '享受医疗待遇情况', 0, 1, '1', '2019-05-30 10:40:28', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (237, '请假', '8adcf7dd6b50c41a016b50c41aae', 'dict_attendance', '出勤记录', 0, 1, '1', '2019-06-13 20:16:35', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (238, '行动不便', '8adcf7dd6b50c451016b50c451c0', 'dict_attendance', '出勤记录', 0, 1, '1', '2019-06-13 20:17:34', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (239, '其他', '8adcf7dd6b50c485016b50c4855e', 'dict_attendance', '出勤记录', 0, 1, '1', '2019-06-13 20:18:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (248, '党员大会', '8adcf7f96b54cab9016b54ceb77c', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:06:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (249, '支委会', '8adcf7f96b54cab9016b54ced4fd', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:06:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (250, '党小组会', '8adcf7f96b54cab9016b54cf07bf', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:06:23', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (251, '党课', '8adcf7f96b54cab9016b54cf27af', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:06:31', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (252, '主题党日活动', '8adcf7f96b54cab9016b54cf6498', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:06:46', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (253, '民主评议党员', '8adcf7f96b54cab9016b54cfb348', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:07:06', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (254, '其他', '8adcf7f96b54cab9016b54cfe195', 'dict_org_life', '组织生活', 0, 1, '1', '2019-06-14 15:07:18', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (263, '先锋队', '8adcf7f96b54cab9016b54d65fba', 'dict_party_pioneers', '老党员先锋队', 0, 1, '1', '2019-06-14 15:14:24', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (264, '宣讲队', '8adcf7f96b54cab9016b54d6852c', 'dict_party_pioneers', '老党员先锋队', 0, 1, '1', '2019-06-14 15:14:33', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (265, '指导员', '8adcf7f96b54cab9016b54d6abec', 'dict_party_pioneers', '老党员先锋队', 0, 1, '1', '2019-06-14 15:14:43', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (273, '市级', '8a7d86d26b6f7a36016b6f7a366f', 'dict_hierarchy', '层级', 0, 1, '1', '2019-06-19 19:23:29', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (274, '区级', '8a7d86d26b6f7a36016b6f7a5d67', 'dict_hierarchy', '层级', 0, 1, '1', '2019-06-19 19:23:39', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (275, '街道乡镇', '8a7d86d26b6f7a36016b6f7a7902', 'dict_hierarchy', '层级', 0, 1, '1', '2019-06-19 19:23:46', '1', '2019-08-01 11:31:27', 0, '1000');
INSERT INTO `dictionary` VALUES (280, '不能自理', '8adcf7c96b8734cc016b8734cc8b', 'dict_health_status', '健康状况', 0, 1, '1', '2019-06-24 09:58:33', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (281, '其他', '8adcf7c96b8734cc016b8734e88b', 'dict_health_status', '健康状况', 0, 1, '1', '2019-06-24 09:58:40', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (297, '其他', '40fd998a6b97e32b016b98519fe4', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:43:35', '1', '2019-06-27 17:43:50', 0, '1000');
INSERT INTO `dictionary` VALUES (299, '文盲与半文盲', '40fd998a6b97e32b016b9851fce9', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:43:58', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (300, '小学', '40fd998a6b97e32b016b985212e5', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:04', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (301, '初中', '40fd998a6b97e32b016b98522ac3', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:10', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (302, '高中', '40fd998a6b97e32b016b98524752', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:17', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (303, '技工学校', '40fd998a6b97e32b016b98525ccf', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:23', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (304, '中专', '40fd998a6b97e32b016b98526ff0', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:28', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (305, '大专', '40fd998a6b97e32b016b9852843b', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:33', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (306, '大学本科', '40fd998a6b97e32b016b98529fd2', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:40', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (307, '硕士', '40fd998a6b97e32b016b9852b5de', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:46', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (308, '博士', '40fd998a6b97e32b016b9852d5e8', 'dict_degree', '文化程度', 0, 1, '1', '2019-06-27 17:44:54', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (340, '清明节', '40fd998a6bd59562016bdac2314a', 'dict_message_type', '短信模板类型', 0, 1, '1', '2019-07-10 15:21:28', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (341, '共青团员', '40fd998a6c4ed3af016c624db0d3', 'dict_political_status', '政治面貌', 0, 3, '1', '2019-08-05 23:02:34', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (342, '民革党员', '40fd998a6c4ed3af016c624deb77', 'dict_political_status', '政治面貌', 0, 4, '1', '2019-08-05 23:02:49', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (343, '民盟盟员', '40fd998a6c4ed3af016c624e0af1', 'dict_political_status', '政治面貌', 0, 5, '1', '2019-08-05 23:02:58', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (344, '民建会员', '40fd998a6c4ed3af016c624e38ac', 'dict_political_status', '政治面貌', 0, 6, '1', '2019-08-05 23:03:09', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (345, '民进会员', '40fd998a6c4ed3af016c624e60ef', 'dict_political_status', '政治面貌', 0, 7, '1', '2019-08-05 23:03:20', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (346, '农工党党员', '40fd998a6c4ed3af016c624e8376', 'dict_political_status', '政治面貌', 0, 8, '1', '2019-08-05 23:03:28', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (347, '致公党党员', '40fd998a6c4ed3af016c624ebcc2', 'dict_political_status', '政治面貌', 0, 9, '1', '2019-08-05 23:03:43', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (348, '九三学社社员', '40fd998a6c4ed3af016c624f07bc', 'dict_political_status', '政治面貌', 0, 10, '1', '2019-08-05 23:04:02', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (349, '台盟盟员', '40fd998a6c4ed3af016c624f515b', 'dict_political_status', '政治面貌', 0, 11, '1', '2019-08-05 23:04:21', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (350, '无党派人士', '40fd998a6c4ed3af016c624f8646', 'dict_political_status', '政治面貌', 0, 12, '1', '2019-08-05 23:04:35', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (351, '群众', '40fd998a6c4ed3af016c624f9898', 'dict_political_status', '政治面貌', 0, 13, '1', '2019-08-05 23:04:39', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (352, '正省(部)级医疗待遇', '40fd998a6c4ed3af016c85e35a4c', 'dict_treatment_now', '现享受待遇', 0, 1, '1', '2019-08-12 20:52:45', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (353, '副省(部)级医疗待遇', '40fd998a6c4ed3af016c85e37780', 'dict_treatment_now', '现享受待遇', 0, 1, '1', '2019-08-12 20:52:53', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (354, '副乡(科)级待遇', '40fd998a6c4ed3af016c85e3cd09', 'dict_treatment_now', '现享受待遇', 0, 1, '1', '2019-08-12 20:53:15', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (355, '其他', '40fd998a6c4ed3af016c85e3f746', 'dict_treatment_now', '现享受待遇', 0, 1, '1', '2019-08-12 20:53:25', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (356, '生日看望', '402883ea73c687ef0173c687ef71', 'dict_visit_type', '走访慰问类型', 0, 1, '1', '2020-08-07 09:28:07', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (357, '住院慰问', '402883ea73c689120173c68912b9', 'dict_visit_type', '走访慰问类型', 0, 1, '1', '2020-08-07 09:28:07', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (358, '节日慰问', '402883ea73c68c090173c68c09f4', 'dict_visit_type', '走访慰问类型', 0, 1, '1', '2020-08-07 09:28:07', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (359, '遗属看望', '402883ea73c68c3e0173c68c3e22', 'dict_visit_type', '走访慰问类型', 0, 1, '1', '2020-08-07 09:28:07', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (360, '日常走访', '402883ea73c68c5d0173c68c5da8', 'dict_visit_type', '走访慰问类型', 0, 1, '1', '2020-08-07 09:28:07', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (361, '异地安置人员慰问', '402883ea73c68c7f0173c68c7f63', 'dict_visit_type', '走访慰问类型', 0, 1, '1', '2020-08-07 09:28:07', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (362, '公务员（参公管理）', 'a969b7fef1b811ea9cdd6c4b90894a7d', 'dict_personnel_category', '人员类别', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (363, '事业单位', 'bfbbe452f1b811ea9cdd6c4b90894a7d', 'dict_personnel_category', '人员类别', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (364, '企业', 'e9de8fc5f1b811ea9cdd6c4b90894a7d', 'dict_personnel_category', '人员类别', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (365, '省级机关及其直属单位', '28257c9df1b911ea9cdd6c4b90894a7d', 'dict_organization_area', '组织区域', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (366, '省以下各级机关及其直属单位', '05005945f26c11ea9cdd6c4b90894a7d', 'dict_organization_area', '组织区域', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (367, '高等院校', '58723ebef1b911ea9cdd6c4b90894a7d', 'dict_organization_area', '组织区域', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (368, '国有企业', '5dd613b5f1b911ea9cdd6c4b90894a7d', 'dict_organization_area', '组织区域', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');
INSERT INTO `dictionary` VALUES (369, '乡镇街道', '632e35bcf1b911ea9cdd6c4b90894a7d', 'dict_organization_area', '组织区域', 0, 1, '1', '2020-09-08 17:49:11', NULL, NULL, 0, '1000');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sort` bigint unsigned NOT NULL COMMENT '单位排名',
  `organization_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '单位名称',
  `parent_employer_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '父单位id',
  `dict_rank` int(0) NULL DEFAULT NULL COMMENT '单位等级',
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_deleted` tinyint(0) NOT NULL,
  `organization_telphone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_org_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `sort`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `pare_id`(`parent_employer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1000', 1, '省委老干部局', '0', 0, '2018-09-12 18:41:25', '2018-11-06 09:02:22', 0, '1321321321', '1', '1', '1000');
INSERT INTO `organization` VALUES ('4028b23f738f519401738f5194b9', 0, '测试单位', '1000', 1, '2020-07-27 16:09:15', '2020-10-20 14:17:31', 0, 'string', '1', '1000', '1000');
INSERT INTO `organization` VALUES ('8a7d93d375401e770175401e770d', 1, '新增单位test', '1000', 1, '2020-10-19 17:09:00', '2020-10-20 14:17:31', 0, NULL, '1', '1000', '1000');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_deleted` tinyint(0) NOT NULL,
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_org_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_admin` tinyint(0) NOT NULL COMMENT '是否为管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('402882866a4dab69016a4dab69dc', '超级管理员', '超级管理员', '2019-04-24 12:48:29', '2019-06-22 19:03:42', 0, '1', '1', '1000', 1);
INSERT INTO `role` VALUES ('402882866a4dba7f016a4dba84d1', '单位管理员（请勿删除）', '单位管理员（请勿删除）', '2019-04-24 13:03:50', '2019-06-28 18:34:04', 0, '1', '1', '1000', 1);
INSERT INTO `role` VALUES ('402882866a4dba7f016a4dbbba05', '工作人员（请勿删除）', '工作人员（请勿删除）', '2019-04-24 13:05:10', '2020-10-20 18:48:44', 0, '1', '1', '1000', 0);
INSERT INTO `role` VALUES ('8adcf88b75459cf40175459cf4a0', '老同志', '老同志', '2020-10-20 18:45:15', '2020-10-20 18:48:44', 0, '1', '1', '1000', 0);

-- ----------------------------
-- Table structure for role_rule
-- ----------------------------
DROP TABLE IF EXISTS `role_rule`;
CREATE TABLE `role_rule`  (
  `role_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `ruler_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_deleted` tinyint(0) NOT NULL,
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_org_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色资源关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_rule
-- ----------------------------
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '10', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-07', '2019-06-20 12:48:04', NULL, 1, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-09', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-10', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-11', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '03-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '03-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '03-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '03-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '03-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-04', '2019-06-20 12:48:04', NULL, 1, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '09', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '09-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '09-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '10-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '11-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '01-12', '2019-11-06 14:34:08', NULL, 0, '1', '', '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '09-03', '2019-11-11 11:14:21', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-08', '2020-01-03 10:56:41', NULL, 1, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-08', '2020-01-03 10:56:41', NULL, 1, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '12', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '14', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '14-01', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '14-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '14-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '02-08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '10-02', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '07-08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-04', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '13-09', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-05', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-06', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-07', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-08', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '04-09', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '08-09', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05-03', '2019-06-20 12:48:04', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05-04', '2020-08-10 10:43:50', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05-05', '2020-08-11 13:57:07', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '05-06', '2020-08-11 13:57:20', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-01', '2020-08-11 16:03:44', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-02', '2020-08-11 16:04:00', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('402882866a4dab69016a4dab69dc', '06-03', '2020-08-11 16:04:13', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('8adcf88b75459cf40175459cf4a0', '01', '2020-10-20 18:51:26', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_rule` VALUES ('8adcf88b75459cf40175459cf4a0', '01-02', '2020-10-20 18:51:26', NULL, 0, '1', NULL, '1000');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user`  (
  `role_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_deleted` tinyint(0) NOT NULL,
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_org_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('402882866a4dab69016a4dab69dc', '1', '2019-04-24 12:59:47', '2020-10-20 15:21:29', 0, '1', '1', '1000');
INSERT INTO `role_user` VALUES ('402882866a4dba7f016a4dba84d1', '2', '2019-04-24 12:59:47', '2019-06-20 14:38:38', 0, '1', '1', '1000');
INSERT INTO `role_user` VALUES ('402882866a4dba7f016a4dbbba05', '8adcf7ea747ad5c001747ad5c079', '2020-09-11 09:44:24', NULL, 0, '1', NULL, '4028b23f738f519401738f5194b9');
INSERT INTO `role_user` VALUES ('402882866a4dab69016a4dab69dc', '0', '2020-10-20 18:14:25', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_user` VALUES ('402882866a4dab69016a4dab69dc', '0', '2020-10-20 18:17:00', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_user` VALUES ('402882866a4dab69016a4dab69dc', '0', '2020-10-20 18:18:58', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_user` VALUES ('402882866a4dab69016a4dab69dc', '0', '2020-10-20 18:19:32', NULL, 0, '1', NULL, '1000');
INSERT INTO `role_user` VALUES ('402882866a4dab69016a4dab69dc', '8adcf88b754586cd01754586cd29', '2020-10-20 18:21:19', NULL, 0, '1', NULL, '1000');

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `rule_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `remark` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_deleted` tinyint(0) NOT NULL,
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_org_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `hideIn_menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('01', '离退休干部', '01', '离退休干部', '00', '2019-04-25 10:21:00', NULL, 0, '1', NULL, '1000', '/personalInformation', 'personalInformation', NULL, 'false');
INSERT INTO `rule` VALUES ('01-01', '信息维护', '01-01', '信息维护', '01', '2019-04-25 10:31:43', '2020-10-20 14:38:18', 0, '1', '1', '1000', '/personalInformation/basicInforList', 'basicInforList', './PersonalInformation/BasicInforList', 'false');
INSERT INTO `rule` VALUES ('01-02', '异地安置', '01-02', '异地安置', '01', '2019-04-25 10:34:07', '2020-10-20 14:38:18', 0, '1', '1', '1000', '/personalInformation/deathInforList', 'deathInforList', './PersonalInformation/DeathInforList', 'false');
INSERT INTO `rule` VALUES ('01-03', '照片信息', '01-03', '照片信息', '01', '2019-04-25 10:34:37', NULL, 1, '1', NULL, '1000', '/personalInformation/survivorInforList', 'survivorInforList', './PersonalInformation/SurvivorInforList', 'false');
INSERT INTO `rule` VALUES ('01-04', '银色人才', '01-04', '银色人才', '01', '2019-04-25 10:35:03', NULL, 0, '1', NULL, '1000', '/personalInformation/otherInforList', 'otherInforList', './PersonalInformation/OtherInforList', 'false');
INSERT INTO `rule` VALUES ('01-05', '兴趣爱好', '01-05', '兴趣爱好', '01', '2019-06-19 20:26:49', NULL, 0, '1', NULL, '1000', '/personalInformation/personFlag', 'personFlag', './PersonalInformation/PersonFlag', 'false');
INSERT INTO `rule` VALUES ('01-06', '生日提醒', '01-06', '生日提醒', '01', '2019-04-25 10:37:45', NULL, 0, '1', NULL, '1000', '/personalInformation/birthdayRemainder', 'birthdayRemainder', './PersonalInformation/BirthdayRemainder', 'false');
INSERT INTO `rule` VALUES ('01-07', '离世管理', '01-07', '离世管理', '01', '2019-04-25 10:37:58', NULL, 0, '1', NULL, '1000', '/personalInformation/statisticsAnalysis', 'statisticsAnalysis', './PersonalInformation/DataStatics', 'false');
INSERT INTO `rule` VALUES ('01-08', '统计分析', '01-08', '统计分析', '01', '2019-11-06 11:00:52', NULL, 0, '1', '', '1000', '/personalInformation/statisticsAnnals', 'statisticsAnnals', './PersonalInformation/StatisticsAnnals', 'false');
INSERT INTO `rule` VALUES ('01-09', '年报统计', '01-09', '年报统计', '01', '2019-11-06 11:00:52', NULL, 0, '1', '', '1000', '/personalInformation/statisticsAnnals', 'statisticsAnnals', './PersonalInformation/StatisticsAnnals', 'false');
INSERT INTO `rule` VALUES ('02', '琼崖本色', '02', '琼崖本色', '00', '2019-04-25 10:25:00', NULL, 0, '1', NULL, '1000', '/partyZone', 'partyZone', NULL, 'false');
INSERT INTO `rule` VALUES ('02-01', '支部信息', '02-01', '支部信息', '02', '2019-04-25 12:14:51', NULL, 0, '1', NULL, '1000', '/partyZone/branchInfoList', 'branchInfoList', './PartyZone/BranchInfoList', 'false');
INSERT INTO `rule` VALUES ('02-02', '支部活动', '02-02', '支部活动', '02', '2019-04-25 12:15:09', NULL, 0, '1', NULL, '1000', '/partyZone/branchActivityList/8adcf7f96b54cab9016b54ceb77c', 'branchActivityList', './PartyZone/BranchActivityList', 'false');
INSERT INTO `rule` VALUES ('02-03', '学习记录', '02-03', '学习记录', '02', '2019-04-25 12:15:27', NULL, 0, '1', NULL, '1000', '/partyZone/onlineLearning/1', 'onlineLearning', './PartyZone/OnlineLearning', 'false');
INSERT INTO `rule` VALUES ('02-04', '党费记录', '02-04', '党费记录', '02', '2019-04-25 12:15:46', NULL, 0, '1', NULL, '1000', '/partyZone/attendInfoList', 'attendInfoList', './PartyZone/AttendInfoList', 'false');
INSERT INTO `rule` VALUES ('02-05', '网络课堂', '02-05', '网络课堂', '02', '2019-04-25 12:16:03', NULL, 0, '1', NULL, '1000', '/partyZone/membershipInfoList', 'membershipInfoList', './PartyZone/MembershipInfoList', 'false');
INSERT INTO `rule` VALUES ('02-06', '政策园地', '02-06', '政策园地', '02', '2019-06-19 20:29:17', NULL, 0, '1', NULL, '1000', '/partyZone/policy/1', 'policy', './PartyZone/Policy', 'false');
INSERT INTO `rule` VALUES ('02-07', '流动党员登记', '02-07', '流动党员登记', '02', '2020-01-03 18:05:52', NULL, 0, '1', NULL, '1000', '', '', '', 'false');
INSERT INTO `rule` VALUES ('03', '南海初心', '03', '南海初心', '00', '2019-04-25 10:25:48', NULL, 0, '1', NULL, '1000', '/positiveEnergy', 'positiveEnergy', NULL, 'false');
INSERT INTO `rule` VALUES ('03-01', '关工工作', '03-01', '关工工作', '03', '2019-04-25 12:17:21', NULL, 0, '1', NULL, '1000', '/positiveEnergy/examplesAround', 'examplesAround', './positiveEnergy/ExamplesAround', 'false');
INSERT INTO `rule` VALUES ('03-02', '社团之家', '03-02', '社团之家', '03', '2019-04-25 12:17:36', NULL, 0, '1', NULL, '1000', '/positiveEnergy/advanceModel/individual', 'advancedIndividualList', './PositiveEnergy/AdvancedModelList', 'false');
INSERT INTO `rule` VALUES ('03-03', '活动信息', '03-03', '活动信息', '03', '2019-06-19 20:35:26', NULL, 0, '1', NULL, '1000', '/positiveEnergy/event/origin', 'event', './PositiveEnergy/Event', 'false');
INSERT INTO `rule` VALUES ('03-04', '成果展示', '03-04', '成果展示', '03', '2019-06-19 20:36:31', NULL, 0, '1', NULL, '1000', '/positiveEnergy/pioneers', 'pioneers', './PositiveEnergy/Pioneers', 'false');
INSERT INTO `rule` VALUES ('03-05', '先进事迹', '03-05', '先进事迹', '03', '2019-06-19 20:38:27', NULL, 0, '1', NULL, '1000', '/positiveEnergy/adviceSuggestion', 'adviceSuggestion', './PositiveEnergy/adviceSuggestion', 'false');
INSERT INTO `rule` VALUES ('03-06', '经验介绍', '03-06', '经验介绍', '03', '2019-06-19 20:38:27', NULL, 0, '1', NULL, '1000', '/positiveEnergy/adviceSuggestion', 'adviceSuggestion', './PositiveEnergy/adviceSuggestion', 'false');
INSERT INTO `rule` VALUES ('03-07', '五老风采', '03-07', '五老风采', '03', '2019-06-19 20:38:27', NULL, 0, '1', NULL, '1000', '/positiveEnergy/adviceSuggestion', 'adviceSuggestion', './PositiveEnergy/adviceSuggestion', 'false');
INSERT INTO `rule` VALUES ('03-08', '志愿团队', '03-08', '志愿团队', '03', '2019-06-19 20:38:27', NULL, 0, '1', NULL, '1000', '/positiveEnergy/adviceSuggestion', 'adviceSuggestion', './PositiveEnergy/adviceSuggestion', 'false');
INSERT INTO `rule` VALUES ('04', '椰岛乐园', '04', '椰岛乐园', '00', '2019-04-25 10:26:01', NULL, 0, '1', NULL, '1000', '/senileUniversity', 'senileUniversity', '', 'false');
INSERT INTO `rule` VALUES ('04-01', '老年大学', '04-01', '老年大学', '04', '2019-04-25 12:18:15', NULL, 0, '1', NULL, '1000', '/senileUniversity/universityIntroList', 'universityIntroList', './SenileUniversity/UniversityIntroList', 'false');
INSERT INTO `rule` VALUES ('04-02', '作品园地', '04-02', '作品园地', '04', '2019-04-25 12:18:37', NULL, 0, '1', NULL, '1000', '/senileUniversity/courseManagementList', 'courseManagementList', './SenileUniversity/CourseManagementList', 'false');
INSERT INTO `rule` VALUES ('04-03', '就医指南', '04-03', '就医指南', '04', '2019-04-25 12:19:14', NULL, 0, '1', NULL, '1000', '/senileUniversity/teacherSharelist', 'teacherSharelist', './SenileUniversity/TeacherSharelist', 'false');
INSERT INTO `rule` VALUES ('04-04', '生活服务', '04-04', '生活服务', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/calligraphyNetworkCourseList', 'calligraphyNetworkCourseList', './SenileUniversity/CalligraphyNetworkCourseList', 'false');
INSERT INTO `rule` VALUES ('04-05', '社保认证', '04-05', '社保认证', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/paintingNetworkList', 'paintingNetworkList', './SenileUniversity/PaintingNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-06', '异地居住', '04-06', '异地居住', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/literatureHistoryNetworkList', 'literatureHistoryNetworkList', './SenileUniversity/LiteratureHistoryNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-07', '活动中心', '04-07', '活动中心', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/stylisticNetworkList', 'stylisticNetworkList', './SenileUniversity/StylisticNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-08', '涉老政策', '04-08', '涉老政策', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/scienceNetworkList', 'scienceNetworkList', './SenileUniversity/ScienceNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-09', '助老志愿', '04-09', '助老志愿', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/foreignLanguageNetworkList', 'foreignLanguageNetworkList', './SenileUniversity/ForeignLanguageNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-10', '网络报名', '04-10', '网络报名', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/foreignLanguageNetworkList', 'foreignLanguageNetworkList', './SenileUniversity/ForeignLanguageNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-11', '社保查询', '04-11', '社保查询', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/foreignLanguageNetworkList', 'foreignLanguageNetworkList', './SenileUniversity/ForeignLanguageNetworkList', 'false');
INSERT INTO `rule` VALUES ('04-12', '医保查询', '04-12', '医保查询', '04', '2019-04-25 12:18:55', NULL, 0, '1', NULL, '1000', '/senileUniversity/foreignLanguageNetworkList', 'foreignLanguageNetworkList', './SenileUniversity/ForeignLanguageNetworkList', 'false');
INSERT INTO `rule` VALUES ('05', '工作记录', '05', '工作记录', '00', '2019-04-25 10:27:48', NULL, 0, '1', NULL, '1000', '/activityCenter', 'activityCenter', NULL, 'false');
INSERT INTO `rule` VALUES ('05-01', '住院登记', '05-01', '住院登记', '05', '2019-04-25 12:19:59', NULL, 0, '1', NULL, '1000', '/activityCenter/centreIntroList', 'centreIntroList', './ActivityCenter/CentreIntroList', 'false');
INSERT INTO `rule` VALUES ('05-02', '走访慰问', '05-02', '走访慰问', '05', '2019-04-25 12:20:26', NULL, 0, '1', NULL, '1000', '/activityCenter/teamIntroList', 'teamIntroList', './ActivityCenter/TeamIntroList', 'false');
INSERT INTO `rule` VALUES ('05-03', '困难帮扶', '05-03', '困难帮扶', '05', '2019-04-25 12:20:26', NULL, 0, '1', NULL, '1000', '/activityCenter/eTicketing', 'eTicketing', './ActivityCenter/ETicketing', 'false');
INSERT INTO `rule` VALUES ('05-04', '审批备案', '05-04', '审批备案', '05', '2019-04-25 12:20:26', NULL, 0, '1', NULL, '1000', '/activityCenter/eTicketing', 'eTicketing', './ActivityCenter/ETicketing', 'false');
INSERT INTO `rule` VALUES ('05-05', '外出登记', '05-05', '外出登记', '05', '2019-04-25 12:20:26', NULL, 0, '1', NULL, '1000', '/activityCenter/eTicketing', 'eTicketing', './ActivityCenter/ETicketing', 'false');
INSERT INTO `rule` VALUES ('05-06', '证照登记', '05-06', '证照登记', '05', '2019-04-25 12:20:26', NULL, 0, '1', NULL, '1000', '/activityCenter/eTicketing', 'eTicketing', './ActivityCenter/ETicketing', 'false');
INSERT INTO `rule` VALUES ('06', '工作助手', '06', '工作助手', '00', '2019-04-25 10:28:29', NULL, 0, '1', NULL, '1000', '/oldResource', 'oldResource', NULL, 'false');
INSERT INTO `rule` VALUES ('06-01', '工作人员电话簿', '06-01', '工作人员电话簿', '06', '2019-04-25 12:22:09', NULL, 0, '1', NULL, '1000', '/oldResource/hospitalList', 'hospitalList', './OldResource/HospitalList', 'false');
INSERT INTO `rule` VALUES ('06-02', '政策规定与解答', '06-02', '政策规定与解答', '06', '2019-04-25 12:22:21', NULL, 0, '1', NULL, '1000', '/oldResource/communityMedicalCareList', 'communityMedicalCareList', './OldResource/CommunityMedicalCareList', 'false');
INSERT INTO `rule` VALUES ('06-03', '收发文件', '06-03', '收发文件', '06', '2019-04-25 12:22:47', NULL, 0, '1', NULL, '1000', '/oldResource/pensionAgencyList', 'pensionAgencyList', './OldResource/PensionAgencyList', 'false');
INSERT INTO `rule` VALUES ('07', '信息发布', '07', '信息发布', '00', '2019-04-25 10:28:59', NULL, 0, '1', NULL, '1000', '/pensionService', 'pensionService', NULL, 'false');
INSERT INTO `rule` VALUES ('07-01', '通知公告', '07-01', '通知公告', '07', '2019-04-25 12:25:49', NULL, 0, '1', NULL, '1000', '/pensionService/birthdayVisiting', 'birthdayVisiting', './PensionService/BirthdayVisiting', 'false');
INSERT INTO `rule` VALUES ('07-02', '图片新闻', '07-02', '图片新闻', '07', '2019-04-25 12:26:03', NULL, 0, '1', NULL, '1000', '/pensionService/treatmentList', 'treatmentList', './PensionService/TreatmentList', 'false');
INSERT INTO `rule` VALUES ('07-03', '新闻动态', '07-03', '新闻动态', '07', '2019-04-25 12:26:15', NULL, 0, '1', NULL, '1000', '/pensionService/hardList', 'hardList', './PensionService/HardList', 'false');
INSERT INTO `rule` VALUES ('07-04', '每日播报', '07-04', '每日播报', '07', '2019-04-25 12:26:28', NULL, 1, '1', NULL, '1000', '/pensionService/restRecordList', 'restRecordList', './PensionService/RestRecordList', 'false');
INSERT INTO `rule` VALUES ('08', '系统管理', '08', '系统管理', '00', '2019-04-25 10:30:04', NULL, 0, '1', NULL, '1000', '/systemManagement', 'systemManagement', NULL, 'false');
INSERT INTO `rule` VALUES ('08-01', '单位管理', '08-01', '单位管理', '08', '2019-04-25 12:29:22', NULL, 0, '1', NULL, '1000', '/systemManagement/changePassword', 'changePassword', './systemManagement/changePassword', 'false');
INSERT INTO `rule` VALUES ('08-02', '角色管理', '08-02', '角色管理', '08', '2019-05-27 14:11:15', NULL, 0, '1', NULL, '1000', '/systemManagement/organizationDirectory', 'organizationDirectory', './systemManagement/organizationDirectory', 'false');
INSERT INTO `rule` VALUES ('08-03', '角色授权', '08-03', '角色授权', '08', '2019-05-27 14:12:32', NULL, 0, '1', NULL, '1000', '/systemManagement/roleManagement', 'roleManagement', './systemManagement/roleManagement', 'false');
INSERT INTO `rule` VALUES ('08-04', '密码管理', '08-04', '密码管理', '08', '2019-04-25 12:30:24', NULL, 0, '1', NULL, '1000', '/systemManagement/authorityManagement', 'authorityManagement', './systemManagement/authorityManagement', 'false');
INSERT INTO `rule` VALUES ('08-05', '字典管理', '08-05', '字典管理', '08', '2019-04-25 12:30:32', NULL, 0, '1', NULL, '1000', '/systemManagement/dictionaryManagement', 'dictionaryManagement', '/systemManagement/dictionaryManagement', 'false');
INSERT INTO `rule` VALUES ('08-06', '监测中心', '08-06', '监测中心', '08', '2019-04-25 12:30:50', NULL, 0, '1', NULL, '1000', '/systemManagement/monitor', 'monitor', './systemManagement/monitor', 'false');
INSERT INTO `rule` VALUES ('08-07', '文件下载', '08-07', '文件下载', '08', '2019-05-27 14:13:39', NULL, 0, '1', NULL, '1000', '/systemManagement/download', 'download', './systemManagement/download', 'false');
INSERT INTO `rule` VALUES ('9', '首页', '9', '首页', '00', '2019-05-27 17:44:09', '2019-05-27 17:46:21', 0, '1', NULL, '1000', '/home', 'home', './menuConfig', NULL);

-- ----------------------------
-- Table structure for sys_log_error
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_error`;
CREATE TABLE `sys_log_error`  (
  `id` bigint(0) NOT NULL COMMENT 'id',
  `request_uri` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求URI',
  `request_method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方式',
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数',
  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户代理',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作IP',
  `error_info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '异常信息',
  `creator` bigint(0) NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_date`(`create_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '异常日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log_error
-- ----------------------------
INSERT INTO `sys_log_error` VALUES (1311147983191314433, '/renren-admin/sys/menu/list', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'org.apache.shiro.authz.UnauthorizedException: Subject does not have permission [sys:menu:list1]\r\n	at org.apache.shiro.authz.ModularRealmAuthorizer.checkPermission(ModularRealmAuthorizer.java:323)\r\n	at org.apache.shiro.mgt.AuthorizingSecurityManager.checkPermission(AuthorizingSecurityManager.java:137)\r\n	at org.apache.shiro.subject.support.DelegatingSubject.checkPermission(DelegatingSubject.java:209)\r\n	at org.apache.shiro.authz.aop.PermissionAnnotationHandler.assertAuthorized(PermissionAnnotationHandler.java:74)\r\n	at org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor.assertAuthorized(AuthorizingAnnotationMethodInterceptor.java:84)\r\n	at org.apache.shiro.authz.aop.AnnotationsAuthorizingMethodInterceptor.assertAuthorized(AnnotationsAuthorizingMethodInterceptor.java:100)\r\n	at org.apache.shiro.authz.aop.AuthorizingMethodInterceptor.invoke(AuthorizingMethodInterceptor.java:38)\r\n	at org.apache.shiro.spring.security.interceptor.AopAllianceAnnotationsAuthorizingMethodInterceptor.invoke(AopAllianceAnnotationsAuthorizingMethodInterceptor.java:115)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:93)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:688)\r\n	at io.renren.modules.sys.controller.SysMenuController$$EnhancerBySpringCGLIB$$9bb77503.list(<generated>)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\r\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\r\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:892)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:797)\r\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1039)\r\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:942)\r\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1005)\r\n	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:897)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\r\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:882)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:112)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at io.renren.common.xss.XssFilter.doFilter(XssFilter.java:30)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\r\n	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\r\n	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\r\n	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\r\n	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\r\n	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\r\n	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\r\n	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:357)\r\n	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:270)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:118)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:92)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:118)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:93)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:118)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:200)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:118)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\r\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\r\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526)\r\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\r\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\r\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\r\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\r\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)\r\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\r\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:860)\r\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1587)\r\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\r\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\r\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n	at java.lang.Thread.run(Thread.java:745)\r\nCaused by: org.apache.shiro.authz.AuthorizationException: Not authorized to invoke method: public io.renren.common.utils.Result io.renren.modules.sys.controller.SysMenuController.list(java.lang.Integer)\r\n	at org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor.assertAuthorized(AuthorizingAnnotationMethodInterceptor.java:90)\r\n	... 84 more\r\n', 1067246875800000001, '2020-09-30 11:36:54');

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login`  (
  `id` bigint(0) NOT NULL COMMENT 'id',
  `operation` tinyint unsigned NULL COMMENT '用户操作   0：用户登录   1：用户退出',
  `status` tinyint unsigned NOT NULL COMMENT '状态  0：失败    1：成功    2：账号已锁定',
  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户代理',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作IP',
  `creator_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `creator` bigint(0) NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_create_date`(`create_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------
INSERT INTO `sys_log_login` VALUES (1311143797271703554, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-09-30 11:20:16');
INSERT INTO `sys_log_login` VALUES (1311145198970351617, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-09-30 11:25:50');
INSERT INTO `sys_log_login` VALUES (1311145392826888194, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-09-30 11:26:36');
INSERT INTO `sys_log_login` VALUES (1311146343092670465, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-09-30 11:30:23');
INSERT INTO `sys_log_login` VALUES (1311146743464153090, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-09-30 11:31:58');
INSERT INTO `sys_log_login` VALUES (1311146858346115074, 0, 1, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-09-30 11:32:26');
INSERT INTO `sys_log_login` VALUES (1315925361029517313, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-10-13 16:00:29');
INSERT INTO `sys_log_login` VALUES (1315925845308051458, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-10-13 16:02:25');
INSERT INTO `sys_log_login` VALUES (1315928420841345025, 0, 0, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-10-13 16:12:39');
INSERT INTO `sys_log_login` VALUES (1315928827248377858, 0, 1, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-10-13 16:14:16');
INSERT INTO `sys_log_login` VALUES (1316313737947734018, 0, 1, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-10-14 17:43:46');
INSERT INTO `sys_log_login` VALUES (1316314828416442369, 0, 1, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36', '0:0:0:0:0:0:0:1', 'admin', 1067246875800000001, '2020-10-14 17:48:06');

-- ----------------------------
-- Table structure for sys_log_operation
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_operation`;
CREATE TABLE `sys_log_operation`  (
  `id` bigint(0) NOT NULL COMMENT 'id',
  `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户操作',
  `request_uri` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求URI',
  `request_method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方式',
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数',
  `request_time` int unsigned NOT NULL COMMENT '请求时长(毫秒)',
  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户代理',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作IP',
  `status` tinyint unsigned NOT NULL COMMENT '状态  0：失败   1：成功',
  `creator_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `creator` bigint(0) NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_date`(`create_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `organization_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位表主键',
  `user_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `dict_sex` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别\r\n            01 男\r\n            02 女',
  `date_of_birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `create_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_user_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint unsigned NOT NULL COMMENT '是否删除\r\n            00 否\r\n            01 是',
  `create_org_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人组织机构id',
  `party_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '入党时间',
  `time_of_login` datetime(0) NULL DEFAULT NULL,
  `dict_nation` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '民族',
  `dict_political_status` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '政治面貌\r\n            01 中共党员\r\n            02 中共预备党员\r\n            03 共青团员\r\n            04 民革党员\r\n            05 民盟盟员\r\n            06 民建会员\r\n            07 民进会员\r\n            08 农工党党员\r\n            09 致公党党员\r\n            10 九三学社社员\r\n            11 台盟盟员\r\n            12 无党派人士',
  `dict_degree` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文化程度\r\n            01 博士  \r\n            02 硕士 \r\n            03 大学本科 \r\n            04 大专 \r\n            05 中专和中技 \r\n            06 技工学校 \r\n            07 高中\r\n            08 初中 \r\n            09 小学 \r\n            10 文盲与半文盲 \r\n            11 其他',
  PRIMARY KEY (`id`(32)) USING BTREE,
  INDEX `id_user`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '工作人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1000', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '请勿删除', '610122199410162818', '8adcf7c96a48fae4016a4925e34b', '2020-10-20', '123456', '1', '1', '2020-06-03 17:19:49', '2020-10-20 15:33:54', 0, NULL, NULL, '2020-10-20 00:00:00', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('2', '4028b23f738f519401738f5194b9', 'admin1', 'e10adc3949ba59abbe56e057f20f883e', '请勿删除', '610122199410162828', '8adcf7c96a48fae4016a4925e34b', '2018-10-22', '18626485982', '1', '1', '2020-06-03 17:19:49', '2020-10-20 15:33:54', 0, '4028b23f738f519401738f5194b9', '', '2020-07-27 00:00:00', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('8adcf7ea747ad5c001747ad5c079', '4028b23f738f519401738f5194b9', '430102199003074152', 'e10adc3949ba59abbe56e057f20f883e', '张武', '430102199003074152', '8adcf7c96a48fae4016a4925e34b', '1987-05-04', '0898-88888888', '1', NULL, '2020-09-11 09:44:24', NULL, 0, '4028b23f738f519401738f5194b9', NULL, NULL, NULL, '8adcf7c96a48fae4016a4925f283', '40fd998a6b97e32b016b9852d5e8');
INSERT INTO `user` VALUES ('8adcf88b754580b901754580b950', '1000', 'admin ', 'e10adc3949ba59abbe56e057f20f883e', 'test', '231', '13', '2020-10-20', '1111', '1', NULL, '2020-10-20 18:14:25', NULL, 0, '1000', NULL, NULL, '12', '23', '11');
INSERT INTO `user` VALUES ('8adcf88b754582ca01754582ca09', '1000', 'admin ', 'e10adc3949ba59abbe56e057f20f883e', 'test', '2131', '13', '2020-10-20', '11111', '1', NULL, '2020-10-20 18:16:53', NULL, 0, '1000', NULL, NULL, '12', '23', '11');
INSERT INTO `user` VALUES ('8adcf88b754582ca0175458399ea', '1000', 'admin ', 'e10adc3949ba59abbe56e057f20f883e', 'test', '21311', '13', '2020-10-20', '111121', '1', NULL, '2020-10-20 18:17:43', NULL, 0, '1000', NULL, NULL, '12', '23', '11');
INSERT INTO `user` VALUES ('8adcf88b754582ca01754585146c', '1000', 'admin ', 'e10adc3949ba59abbe56e057f20f883e', 'test', '213211', '13', '2020-10-20', '1111121', '1', NULL, '2020-10-20 18:19:20', NULL, 0, '1000', NULL, NULL, '12', '23', '11');
INSERT INTO `user` VALUES ('8adcf88b754586cd01754586cd29', '1000', 'admin ', 'e10adc3949ba59abbe56e057f20f883e', 'test', '2132211', '13', '2020-10-20', '11111121', '1', NULL, '2020-10-20 18:21:07', NULL, 0, '1000', NULL, NULL, '12', '23', '11');

-- ----------------------------
-- Procedure structure for allChildOrganization
-- ----------------------------
DROP PROCEDURE IF EXISTS `allChildOrganization`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `allChildOrganization`(in orgcode varchar(40))
begin	
declare p_done tinyint unsigned default(0); -- 下文中while循环结束的标志	
declare p_depth smallint unsigned default(0); -- 记录查询的深度（循环的次数）

create temporary table resultTemp( 
parentcode varchar(200) ,
orgcode varchar(200) ,
depth smallint unsigned
) engine = memory;
insert into resultTemp values( null , orgcode , p_depth ); -- 先将 输入的orgcode 最为结点的最高级，插入到临时表 resultTemp中
-- 创建第二个临时表tempTab，用于存放子级或者孙级（同一级）的机构信息，然后用该临时表，去查询出下一级的机构信息
create temporary table tempTab engine = memory select * from resultTemp; 
while p_done <> 1 do  -- 循环开始
if exists(  -- 判断机构表_organization ， 是否有相应的下级机构
select 1 from organization org , tempTab  where  org.parent_employer_id = tempTab.orgcode 
) then
-- 根据临时表tempTab 查询出相应的下级机构信息，插入临时表resultTemp中
insert into resultTemp select org.parent_employer_id , org.id , p_depth + 1 from organization org , tempTab 
where org.parent_employer_id = tempTab.orgcode and tempTab.depth = p_depth;
set p_depth = p_depth + 1; 

truncate table tempTab; -- 清空临时表tempTab
insert into tempTab select * from resultTemp where depth = p_depth; -- 将刚查询出的子级机构信息，插入临时表tempTab中
else
set p_done = 1;
end if;
end while;
select org.id , org.parent_employer_id , org.organization_name ,org.dict_organization_type from organization org , 
resultTemp re where org.id = re.orgcode;
-- 删除临时表
drop temporary table if exists resultTemp; 
drop temporary table if exists tempTab;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
