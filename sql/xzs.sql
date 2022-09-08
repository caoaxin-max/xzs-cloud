/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : xzs

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 08/09/2022 16:37:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `class_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级口令',
  `level` int NULL DEFAULT NULL COMMENT '年级',
  `create_time` date NULL DEFAULT NULL COMMENT '创建班级时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (2, '一班', 'a11c9cba-e78b-48fd-b8ce-a635340e73c5', 2, '2022-06-23', b'0');
INSERT INTO `t_class` VALUES (4, '二班', 'efac1ebe-366d-4d6d-b0bd-ce6554de3db9', 1, '2022-06-23', b'1');
INSERT INTO `t_class` VALUES (5, '二班', 'a6551ca4-67a4-441e-8ab9-bd0e2db2adcc', 2, '2022-06-23', b'0');
INSERT INTO `t_class` VALUES (6, '一班', 'f14eda75-07ec-4984-b72e-5285a0948de0', 1, '2022-07-08', b'1');
INSERT INTO `t_class` VALUES (7, '一班', '27d5ba03-1e79-4ced-bbbc-c7fddd6e5df0', 1, '2022-07-08', b'1');
INSERT INTO `t_class` VALUES (8, '一班', '9bbb1a56-0733-450c-ba5a-8f2f4a372cf7', 1, '2022-07-08', b'1');
INSERT INTO `t_class` VALUES (9, '一班', '8fdd1a37-e1c0-456b-82a4-dbb87d715f5e', 1, '2022-07-08', b'1');
INSERT INTO `t_class` VALUES (10, '一班', '740d6f2c-a073-4fd5-9e15-508917d5f5e4', 1, '2022-07-08', b'1');
INSERT INTO `t_class` VALUES (11, '一年级一班', 'b0391c86-726c-4832-8a03-9a7c1b20eaa2', 1, '2022-08-20', b'0');
INSERT INTO `t_class` VALUES (12, '二年级一班', '5367b204-666e-449d-a6ea-4a6eba42cf68', 2, '2022-08-25', b'0');
INSERT INTO `t_class` VALUES (13, '九班', '36b8cac4-3947-496a-890a-4f2860320eac', 2, '2022-08-26', b'0');
INSERT INTO `t_class` VALUES (14, '八班', '4eb03c4b-e369-44de-bbe1-7b8e15539d66', 2, '2022-08-26', b'0');

-- ----------------------------
-- Table structure for t_class_student
-- ----------------------------
DROP TABLE IF EXISTS `t_class_student`;
CREATE TABLE `t_class_student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NULL DEFAULT NULL,
  `student_id` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class_student
-- ----------------------------
INSERT INTO `t_class_student` VALUES (1, 11, 1, '2022-08-20 15:01:01', '2022-08-20 15:01:05');
INSERT INTO `t_class_student` VALUES (2, 11, 13, '2022-08-24 09:20:42', '2022-08-24 09:20:42');
INSERT INTO `t_class_student` VALUES (3, 12, 15, '2022-08-25 16:03:40', '2022-08-25 16:03:40');
INSERT INTO `t_class_student` VALUES (4, 13, 17, '2022-08-26 09:38:41', '2022-08-26 09:38:41');
INSERT INTO `t_class_student` VALUES (5, 14, 22, '2022-08-26 10:52:45', '2022-08-26 10:52:45');

-- ----------------------------
-- Table structure for t_class_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_class_teacher`;
CREATE TABLE `t_class_teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NULL DEFAULT NULL,
  `teacher_id` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class_teacher
-- ----------------------------
INSERT INTO `t_class_teacher` VALUES (1, 1, 6, '2022-06-23 18:28:08', '2022-06-23 18:28:08');
INSERT INTO `t_class_teacher` VALUES (2, 2, 6, '2022-06-23 18:30:41', '2022-06-23 18:30:41');
INSERT INTO `t_class_teacher` VALUES (3, 3, 6, '2022-06-23 19:10:19', '2022-06-23 19:10:19');
INSERT INTO `t_class_teacher` VALUES (5, 5, 6, '2022-06-23 19:22:27', '2022-06-23 19:22:27');
INSERT INTO `t_class_teacher` VALUES (11, 11, 6, '2022-08-20 14:39:03', '2022-08-20 14:39:03');
INSERT INTO `t_class_teacher` VALUES (12, 12, 14, '2022-08-25 15:53:41', '2022-08-25 15:53:41');
INSERT INTO `t_class_teacher` VALUES (13, 13, 16, '2022-08-26 09:14:53', '2022-08-26 09:14:53');
INSERT INTO `t_class_teacher` VALUES (14, 14, 21, '2022-08-26 10:50:25', '2022-08-26 10:50:25');

-- ----------------------------
-- Table structure for t_exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper`;
CREATE TABLE `t_exam_paper`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `subject_id` int NULL DEFAULT NULL COMMENT '学科',
  `paper_type` int NULL DEFAULT NULL COMMENT '试卷类型( 1.固定试卷 4.时段试卷 6.任务试卷 )',
  `grade_level` int NULL DEFAULT NULL COMMENT '年级',
  `score` int NULL DEFAULT NULL COMMENT '试卷总分(千分制)',
  `question_count` int NULL DEFAULT NULL COMMENT '题目数量',
  `suggest_time` int NULL DEFAULT NULL COMMENT '建议时长(分钟)',
  `limit_start_time` datetime NULL DEFAULT NULL COMMENT '时段试卷 开始时间',
  `limit_end_time` datetime NULL DEFAULT NULL COMMENT '时段试卷 结束时间',
  `text_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '试卷框架 内容为JSON',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0',
  `task_exam_id` int NULL DEFAULT NULL,
  `status` int NOT NULL DEFAULT 0 COMMENT '是否启用该试卷(1.启用 2禁用)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_exam_paper
-- ----------------------------
INSERT INTO `t_exam_paper` VALUES (8, '随堂练习', 3, 6, 1, 10, 1, 10, NULL, NULL, '[{\"name\":\"简答题\",\"questionItems\":[{\"id\":3,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":3,\"title\":\"<p style=\\\"text-align: left;\\\">写观看西游记的读后感，要求三百字以内。</p>\",\"items\":[],\"analyze\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"correct\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-07-06 09:16:15', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (9, '第一次考试', 2, 1, 1, 3, 2, 20, NULL, NULL, '[{\"name\":\"选择题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-07-07 19:09:59', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (10, '假期作业', 2, 4, 1, 14, 4, 100, '2022-08-26 00:00:00', '2022-08-27 00:00:00', '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":2,\"questionType\":3,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"A\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"解答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-07-07 19:58:48', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (11, '任务1', 2, 6, 1, 16, 5, 100, NULL, NULL, '[{\"name\":\"单选题aiaiiaia\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":\"\",\"score\":0,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"b\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-07-13 16:04:57', b'0', 14, 0);
INSERT INTO `t_exam_paper` VALUES (12, '任务', 2, 6, 1, 19, 6, 100, NULL, NULL, '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":null,\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null},{\"id\":9,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":null,\"score\":3,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"A\",\"B\"],\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":2,\"questionType\":3,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"A\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-07-13 17:46:30', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (13, '二年级语文试卷1', 5, 6, 2, 2, 1, 20, NULL, NULL, '[{\"name\":\"拼音\",\"questionItems\":[{\"id\":6,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"<p>大小的拼音？</p>\",\"items\":[{\"prefix\":\"A\",\"content\":\"da xiao\",\"id\":null},{\"prefix\":\"B\",\"content\":\"da xi\",\"id\":null},{\"prefix\":\"C\",\"content\":\"da da\",\"id\":null},{\"prefix\":\"D\",\"content\":\"da xia\",\"id\":null}],\"analyze\":\"da xiao\",\"correct\":\"A\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-08-20 10:50:40', b'0', 15, 0);
INSERT INTO `t_exam_paper` VALUES (14, '固定试卷二年级语文', 5, 1, 2, 2, 1, 20, NULL, NULL, '[{\"name\":\"拼音\",\"questionItems\":[{\"id\":6,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"<p>大小的拼音？</p>\",\"items\":[{\"prefix\":\"A\",\"content\":\"da xiao\",\"id\":null},{\"prefix\":\"B\",\"content\":\"da xi\",\"id\":null},{\"prefix\":\"C\",\"content\":\"da da\",\"id\":null},{\"prefix\":\"D\",\"content\":\"da xia\",\"id\":null}],\"analyze\":\"da xiao\",\"correct\":\"A\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-08-20 13:17:09', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (15, '一年级语文试卷', 3, 4, 1, 10, 1, 20, '2022-08-20 00:00:00', '2022-09-12 00:00:00', '[{\"name\":\"简答题\",\"questionItems\":[{\"id\":3,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":3,\"title\":\"<p style=\\\"text-align: left;\\\">写观看西游记的读后感，要求三百字以内。</p>\",\"items\":[],\"analyze\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"correct\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'caoaxin', '2022-08-20 14:45:04', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (16, '固定试卷1', 6, 1, 2, 14, 3, 20, NULL, NULL, '[{\"name\":\"选择题\",\"questionItems\":[{\"id\":11,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}],\"analyze\":\"875\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":12,\"questionType\":3,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"对\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"\",\"questionItems\":[{\"id\":13,\"questionType\":5,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"求证1+1=2\",\"items\":[],\"analyze\":\"因为1+1=2，所以1+1=2\",\"correct\":\"因为1+1=2，所以1+1=2\",\"score\":10,\"difficult\":4,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'zhanglaoshi', '2022-08-25 15:58:12', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (17, '时段试卷1', 6, 4, 2, 4, 2, 20, '2022-08-26 00:00:00', '2022-09-21 00:00:00', '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":11,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}],\"analyze\":\"875\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":12,\"questionType\":3,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"对\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'zhanglaoshi', '2022-08-25 15:59:24', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (18, '任务试卷1', 6, 6, 2, 4, 2, 20, NULL, NULL, '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":11,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}],\"analyze\":\"875\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":12,\"questionType\":3,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"对\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'zhanglaoshi', '2022-08-25 16:00:17', b'0', 16, 0);
INSERT INTO `t_exam_paper` VALUES (19, '固定试卷1', 6, 1, 2, 11, 2, 20, NULL, NULL, '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":14,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}],\"analyze\":\"100\",\"correct\":\"A\",\"score\":1,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":15,\"questionType\":5,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[],\"analyze\":\"略\",\"correct\":\"略\",\"score\":10,\"difficult\":4,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'testTeacher', '2022-08-26 09:32:05', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (20, '二年级数学固定试卷1', 6, 1, 2, 11, 2, 20, NULL, NULL, '[{\"name\":\"选择题\",\"questionItems\":[{\"id\":14,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}],\"analyze\":\"100\",\"correct\":\"A\",\"score\":1,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":15,\"questionType\":5,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[],\"analyze\":\"略\",\"correct\":\"略\",\"score\":10,\"difficult\":4,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'teacherTest', '2022-08-26 10:54:55', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (21, '二年级八班时段试卷', 6, 4, 2, 20, 2, 20, '2022-08-30 00:00:00', '2022-09-21 00:00:00', '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":13,\"questionType\":5,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"求证1+1=2\",\"items\":[],\"analyze\":\"因为1+1=2，所以1+1=2\",\"correct\":\"因为1+1=2，所以1+1=2\",\"score\":10,\"difficult\":4,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":13,\"questionType\":5,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"求证1+1=2\",\"items\":[],\"analyze\":\"因为1+1=2，所以1+1=2\",\"correct\":\"因为1+1=2，所以1+1=2\",\"score\":10,\"difficult\":4,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'teacherTest', '2022-08-26 11:00:05', b'0', NULL, 0);
INSERT INTO `t_exam_paper` VALUES (22, '二年级任务试卷1', 6, 6, 2, 3, 2, 20, NULL, NULL, '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":11,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}],\"analyze\":\"875\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":14,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}],\"analyze\":\"100\",\"correct\":\"A\",\"score\":1,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-08-26 11:03:10', b'0', 17, 0);
INSERT INTO `t_exam_paper` VALUES (23, '二年级语文任务试卷', 5, 6, 2, 4, 2, 20, NULL, NULL, '[{\"name\":\"单选题\",\"questionItems\":[{\"id\":10,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"下面哪个是四大名著之一？\",\"items\":[{\"prefix\":\"A\",\"content\":\"西游记\",\"id\":null},{\"prefix\":\"B\",\"content\":\"百年孤独\",\"id\":null},{\"prefix\":\"C\",\"content\":\"挪威的森林\",\"id\":null},{\"prefix\":\"D\",\"content\":\"斗罗大陆\",\"id\":null}],\"analyze\":\"四大名著是：西游记、红楼梦、三国演义、水浒传\",\"correct\":\"A\",\"score\":2,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":6,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"大小的拼音？\",\"items\":[{\"prefix\":\"A\",\"content\":\"da xiao\",\"id\":null},{\"prefix\":\"B\",\"content\":\"da xi\",\"id\":null},{\"prefix\":\"C\",\"content\":\"da da\",\"id\":null},{\"prefix\":\"D\",\"content\":\"da xia\",\"id\":null}],\"analyze\":\"da xiao\",\"correct\":\"A\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}]', 'admin', '2022-08-26 11:03:37', b'0', 17, 0);

-- ----------------------------
-- Table structure for t_exam_paper_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper_answer`;
CREATE TABLE `t_exam_paper_answer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_paper_id` int NULL DEFAULT NULL,
  `paper_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `paper_type` int NULL DEFAULT NULL COMMENT '试卷类型( 1.固定试卷 4.时段试卷 6.任务试卷 )',
  `subject_id` int NULL DEFAULT NULL COMMENT '	学科',
  `grade_level` int NULL DEFAULT NULL COMMENT '年级',
  `system_score` int NULL DEFAULT NULL COMMENT '	系统判定得分',
  `user_score` int NULL DEFAULT NULL COMMENT '	最终得分(千分制)',
  `paper_score` int NULL DEFAULT NULL COMMENT '试卷总分',
  `question_correct` int NULL DEFAULT NULL COMMENT '做对题目数量',
  `question_count` int NULL DEFAULT NULL COMMENT '题目总数量',
  `do_time` int NULL DEFAULT NULL COMMENT '	做题时间(秒)',
  `status` int NOT NULL DEFAULT 1 COMMENT '试卷状态(1待判分 2完成)',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生',
  `create_time` datetime NULL DEFAULT NULL COMMENT '提交时间',
  `task_exam_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_exam_paper_answer
-- ----------------------------
INSERT INTO `t_exam_paper_answer` VALUES (10, 11, '任务1', 6, 2, 1, 6, 16, 16, 4, 5, 17, 2, 'student', '2022-07-14 20:39:07', 14);
INSERT INTO `t_exam_paper_answer` VALUES (12, 9, '第一次考试', 1, 2, 1, 3, 3, 3, 2, 2, 4, 2, 'student', '2022-07-20 14:15:34', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (13, 9, '第一次考试', 1, 2, 1, 3, 3, 3, 2, 2, 4, 2, 'student', '2022-07-20 14:44:09', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (14, 9, '第一次考试', 1, 2, 1, 1, NULL, 3, 1, 2, 6, 1, 'student', '2022-08-22 15:40:19', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (15, 18, '任务试卷1', 6, 6, 2, 2, 2, 4, 1, 2, 8, 2, 'zhangStudent', '2022-08-25 16:18:16', 16);
INSERT INTO `t_exam_paper_answer` VALUES (16, 16, '固定试卷1', 1, 6, 2, 4, 14, 14, 2, 3, 9, 2, 'zhangStudent', '2022-08-25 16:23:56', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (17, 16, '固定试卷1', 1, 6, 2, 4, NULL, 14, 2, 3, 14, 1, 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (18, 16, '固定试卷1', 1, 6, 2, 4, NULL, 14, 2, 3, 14, 1, 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (19, 19, '固定试卷1', 1, 6, 2, 1, 6, 11, 1, 2, 9, 2, 'testStudent', '2022-08-26 09:44:25', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (20, 19, '固定试卷1', 1, 6, 2, 0, 9, 11, 0, 2, 8, 2, 'testStudent', '2022-08-26 09:44:59', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (21, 19, '固定试卷1', 1, 6, 2, 0, 9, 11, 0, 2, 7, 2, 'testStudent', '2022-08-26 10:16:42', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (22, 19, '固定试卷1', 1, 6, 2, 0, 9, 11, 0, 2, 10, 2, 'testStudent', '2022-08-26 10:17:59', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (23, 19, '固定试卷1', 1, 6, 2, 1, 11, 11, 1, 2, 7, 2, 'testStudent', '2022-08-26 10:21:36', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (24, 20, '二年级数学固定试卷1', 1, 6, 2, 1, 10, 11, 1, 2, 7, 2, 'studentTest', '2022-08-26 11:00:34', NULL);
INSERT INTO `t_exam_paper_answer` VALUES (25, 22, '二年级任务试卷1', 6, 6, 2, 3, 3, 3, 2, 2, 6, 2, 'studentTest', '2022-08-26 11:04:09', 17);

-- ----------------------------
-- Table structure for t_exam_paper_question_customer_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper_question_customer_answer`;
CREATE TABLE `t_exam_paper_question_customer_answer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_id` int NULL DEFAULT NULL COMMENT '	题目Id',
  `exam_paper_id` int NULL DEFAULT NULL COMMENT '	答案Id',
  `exam_paper_answer_id` int NULL DEFAULT NULL,
  `question_type` int NULL DEFAULT NULL COMMENT '	题型',
  `subject_id` int NULL DEFAULT NULL COMMENT '	学科',
  `customer_score` int NULL DEFAULT NULL COMMENT '	得分',
  `question_score` int NULL DEFAULT NULL COMMENT '题目原始分数',
  `question_text_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '问题内容',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '	做题答案',
  `text_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '	做题内容',
  `do_right` bit(1) NULL DEFAULT NULL COMMENT '	是否正确',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '	做题人',
  `create_time` datetime NULL DEFAULT NULL,
  `item_order` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_exam_paper_question_customer_answer
-- ----------------------------
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (13, 1, 11, NULL, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":1}', b'1', 'student', '2022-07-13 16:40:19', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (14, 7, 11, NULL, 1, 2, 0, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', '[]', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":7}', b'0', 'student', '2022-07-13 16:40:19', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (15, 8, 11, NULL, 2, 2, 0, 0, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8}', b'1', 'student', '2022-07-13 16:40:19', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (16, 5, 11, NULL, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"content\":\"b\",\"contentArray\":[],\"questionId\":5}', b'1', 'student', '2022-07-13 16:40:19', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (25, 1, 11, 4, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":1}', b'1', 'student', '2022-07-13 17:23:40', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (26, 7, 11, 4, 1, 2, 0, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', '[]', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":7}', b'0', 'student', '2022-07-13 17:23:40', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (27, 8, 11, 4, 2, 2, 2, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8}', b'1', 'student', '2022-07-13 17:23:40', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (28, 5, 11, 4, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"content\":\"b\",\"contentArray\":[],\"questionId\":5}', b'1', 'student', '2022-07-13 17:23:40', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (29, 1, 12, 5, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":1}', b'1', 'student', '2022-07-13 17:47:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (30, 7, 12, 5, 1, 2, 0, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":7}', b'0', 'student', '2022-07-13 17:47:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (31, 8, 12, 5, 2, 2, 2, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8}', b'1', 'student', '2022-07-13 17:47:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (32, 9, 12, 5, 2, 2, 0, 3, '{\"analyze\":\"<p>略</p>\",\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":9}', b'0', 'student', '2022-07-13 17:47:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (33, 2, 12, 5, 3, 2, 1, 1, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"content\":\"A\",\"contentArray\":[],\"questionId\":2}', b'1', 'student', '2022-07-13 17:47:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (34, 4, 12, 5, 5, 2, 0, 10, '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', '略', '{\"content\":\"略\",\"contentArray\":[],\"questionId\":4}', b'0', 'student', '2022-07-13 17:47:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (35, 1, 12, 6, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":1}', b'1', 'student', '2022-07-14 15:18:53', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (36, 7, 12, 6, 1, 2, 1, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'B', '{\"content\":\"B\",\"contentArray\":[],\"questionId\":7}', b'1', 'student', '2022-07-14 15:18:53', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (37, 8, 12, 6, 2, 2, 2, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8}', b'1', 'student', '2022-07-14 15:18:53', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (38, 9, 12, 6, 2, 2, 3, 3, '{\"analyze\":\"<p>略</p>\",\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}]}', '[\"A\",\"B\"]', '{\"content\":null,\"contentArray\":[\"A\",\"B\"],\"questionId\":9}', b'1', 'student', '2022-07-14 15:18:53', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (39, 2, 12, 6, 3, 2, 1, 1, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"content\":\"A\",\"contentArray\":[],\"questionId\":2}', b'1', 'student', '2022-07-14 15:18:53', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (40, 4, 12, 6, 5, 2, 0, 10, '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', '略', '{\"content\":\"略\",\"contentArray\":[],\"questionId\":4}', NULL, 'student', '2022-07-14 15:18:53', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (41, 1, 12, 7, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":1,\"doRight\":false}', b'1', 'student', '2022-07-14 16:32:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (42, 7, 12, 7, 1, 2, 0, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":7,\"doRight\":false}', b'0', 'student', '2022-07-14 16:32:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (43, 8, 12, 7, 2, 2, 2, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8,\"doRight\":false}', b'1', 'student', '2022-07-14 16:32:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (44, 9, 12, 7, 2, 2, 0, 3, '{\"analyze\":\"<p>略</p>\",\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}]}', '[\"B\",\"C\"]', '{\"content\":null,\"contentArray\":[\"B\",\"C\"],\"questionId\":9,\"doRight\":false}', b'0', 'student', '2022-07-14 16:32:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (45, 2, 12, 7, 3, 2, 1, 1, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"content\":\"A\",\"contentArray\":[],\"questionId\":2,\"doRight\":false}', b'1', 'student', '2022-07-14 16:32:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (46, 4, 12, 7, 5, 2, 0, 10, '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', '略', '{\"content\":\"略\",\"contentArray\":[],\"questionId\":4,\"doRight\":false}', NULL, 'student', '2022-07-14 16:32:46', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (47, 1, 12, 8, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":1,\"doRight\":false,\"itemOrder\":1}', b'1', 'student', '2022-07-14 16:34:45', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (48, 7, 12, 8, 1, 2, 0, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"content\":\"C\",\"contentArray\":[],\"questionId\":7,\"doRight\":false,\"itemOrder\":2}', b'0', 'student', '2022-07-14 16:34:45', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (49, 8, 12, 8, 2, 2, 0, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"C\"]', '{\"content\":null,\"contentArray\":[\"B\",\"C\"],\"questionId\":8,\"doRight\":false,\"itemOrder\":3}', b'0', 'student', '2022-07-14 16:34:45', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (50, 9, 12, 8, 2, 2, 3, 3, '{\"analyze\":\"<p>略</p>\",\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}]}', '[\"A\",\"B\"]', '{\"content\":null,\"contentArray\":[\"A\",\"B\"],\"questionId\":9,\"doRight\":false,\"itemOrder\":4}', b'1', 'student', '2022-07-14 16:34:45', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (51, 2, 12, 8, 3, 2, 1, 1, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"content\":\"A\",\"contentArray\":[],\"questionId\":2,\"doRight\":false,\"itemOrder\":5}', b'1', 'student', '2022-07-14 16:34:45', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (52, 4, 12, 8, 5, 2, 0, 10, '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', '略', '\r\n{\"content\":\"略\",\"contentArray\":[],\"questionId\":4,\"doRight\":null,\"itemOrder\":6}', NULL, 'student', '2022-07-14 16:34:45', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (53, 1, 11, 9, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"epqCustomerAnswerId\":53,\"content\":\"C\",\"contentArray\":[],\"questionId\":1,\"doRight\":null,\"itemOrder\":1,\"score\":null}', b'1', 'student', '2022-07-14 20:26:15', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (54, 7, 11, 9, 1, 2, 1, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'B', '{\"epqCustomerAnswerId\":54,\"content\":\"B\",\"contentArray\":[],\"questionId\":7,\"doRight\":null,\"itemOrder\":2,\"score\":null}', b'1', 'student', '2022-07-14 20:26:15', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (55, 8, 11, 9, 2, 2, 2, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"epqCustomerAnswerId\":55,\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8,\"doRight\":null,\"itemOrder\":3,\"score\":null}', b'1', 'student', '2022-07-14 20:26:15', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (56, 5, 11, 9, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"epqCustomerAnswerId\":56,\"content\":\"b\",\"contentArray\":[],\"questionId\":5,\"doRight\":null,\"itemOrder\":4,\"score\":null}', b'1', 'student', '2022-07-14 20:26:15', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (57, 4, 11, 9, 5, 2, 0, 10, '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":57,\"content\":\"略\",\"contentArray\":[],\"questionId\":4,\"doRight\":null,\"itemOrder\":5,\"score\":null}', NULL, 'student', '2022-07-14 20:26:15', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (58, 1, 11, 10, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"epqCustomerAnswerId\":58,\"content\":\"C\",\"contentArray\":[],\"questionId\":1,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'student', '2022-07-14 20:39:07', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (59, 7, 11, 10, 1, 2, 1, 1, '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'B', '{\"epqCustomerAnswerId\":59,\"content\":\"B\",\"contentArray\":[],\"questionId\":7,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'student', '2022-07-14 20:39:07', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (60, 8, 11, 10, 2, 2, 2, 2, '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', '[\"B\",\"D\"]', '{\"epqCustomerAnswerId\":60,\"content\":null,\"contentArray\":[\"B\",\"D\"],\"questionId\":8,\"doRight\":true,\"itemOrder\":3,\"score\":null}', b'1', 'student', '2022-07-14 20:39:07', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (61, 5, 11, 10, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"epqCustomerAnswerId\":61,\"content\":\"b\",\"contentArray\":[],\"questionId\":5,\"doRight\":true,\"itemOrder\":4,\"score\":null}', b'1', 'student', '2022-07-14 20:39:07', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (62, 4, 11, 10, 5, 2, 10, 10, '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', '长方形', '{\"epqCustomerAnswerId\":62,\"content\":\"长方形\",\"contentArray\":[],\"questionId\":4,\"doRight\":null,\"itemOrder\":5,\"score\":null}', NULL, 'student', '2022-07-14 20:39:07', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (63, 1, 9, 12, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"epqCustomerAnswerId\":63,\"content\":\"C\",\"contentArray\":[],\"questionId\":1,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'student', '2022-07-20 14:15:34', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (64, 5, 9, 12, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"epqCustomerAnswerId\":64,\"content\":\"b\",\"contentArray\":[],\"questionId\":5,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'student', '2022-07-20 14:15:34', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (65, 1, 9, 13, 1, 2, 2, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'C', '{\"epqCustomerAnswerId\":65,\"content\":\"C\",\"contentArray\":[],\"questionId\":1,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'student', '2022-07-20 14:44:09', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (66, 5, 9, 13, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"epqCustomerAnswerId\":66,\"content\":\"b\",\"contentArray\":[],\"questionId\":5,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'student', '2022-07-20 14:44:09', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (67, 1, 9, 14, 1, 2, 0, 2, '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":67,\"content\":\"A\",\"contentArray\":[],\"questionId\":1,\"doRight\":false,\"itemOrder\":1,\"score\":null}', b'0', 'student', '2022-08-22 15:40:19', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (68, 5, 9, 14, 4, 2, 1, 1, '{\"analyze\":\"abcd\",\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}]}', 'b', '{\"epqCustomerAnswerId\":68,\"content\":\"b\",\"contentArray\":[],\"questionId\":5,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'student', '2022-08-22 15:40:19', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (69, 11, 18, 15, 1, 6, 2, 2, '{\"analyze\":\"875\",\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":69,\"content\":\"A\",\"contentArray\":[],\"questionId\":11,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 16:18:16', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (70, 12, 18, 15, 3, 6, 0, 2, '{\"analyze\":\"对\",\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'B', '{\"epqCustomerAnswerId\":70,\"content\":\"B\",\"contentArray\":[],\"questionId\":12,\"doRight\":false,\"itemOrder\":2,\"score\":null}', b'0', 'zhangStudent', '2022-08-25 16:18:16', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (71, 11, 16, 16, 1, 6, 2, 2, '{\"analyze\":\"875\",\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":71,\"content\":\"A\",\"contentArray\":[],\"questionId\":11,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 16:23:56', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (72, 12, 16, 16, 3, 6, 2, 2, '{\"analyze\":\"对\",\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":72,\"content\":\"A\",\"contentArray\":[],\"questionId\":12,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 16:23:56', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (73, 13, 16, 16, 5, 6, 10, 10, '{\"analyze\":\"因为1+1=2，所以1+1=2\",\"title\":\"求证1+1=2\",\"items\":[]}', '因为1+1=2，所以1+1=2', '{\"epqCustomerAnswerId\":73,\"content\":\"因为1+1=2，所以1+1=2\",\"contentArray\":[],\"questionId\":13,\"doRight\":null,\"itemOrder\":3,\"score\":null}', NULL, 'zhangStudent', '2022-08-25 16:23:56', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (74, 11, 16, 17, 1, 6, 2, 2, '{\"analyze\":\"875\",\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":74,\"content\":\"A\",\"contentArray\":[],\"questionId\":11,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (75, 12, 16, 17, 3, 6, 2, 2, '{\"analyze\":\"对\",\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":75,\"content\":\"A\",\"contentArray\":[],\"questionId\":12,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (76, 13, 16, 17, 5, 6, 0, 10, '{\"analyze\":\"因为1+1=2，所以1+1=2\",\"title\":\"求证1+1=2\",\"items\":[]}', '对的', '{\"epqCustomerAnswerId\":76,\"content\":\"对的\",\"contentArray\":[],\"questionId\":13,\"doRight\":null,\"itemOrder\":3,\"score\":null}', NULL, 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (77, 11, 16, 18, 1, 6, 2, 2, '{\"analyze\":\"875\",\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":77,\"content\":\"A\",\"contentArray\":[],\"questionId\":11,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (78, 12, 16, 18, 3, 6, 2, 2, '{\"analyze\":\"对\",\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":78,\"content\":\"A\",\"contentArray\":[],\"questionId\":12,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (79, 13, 16, 18, 5, 6, 0, 10, '{\"analyze\":\"因为1+1=2，所以1+1=2\",\"title\":\"求证1+1=2\",\"items\":[]}', '对的', '{\"epqCustomerAnswerId\":79,\"content\":\"对的\",\"contentArray\":[],\"questionId\":13,\"doRight\":null,\"itemOrder\":3,\"score\":null}', NULL, 'zhangStudent', '2022-08-25 18:54:18', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (80, 14, 19, 19, 1, 6, 1, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":80,\"content\":\"A\",\"contentArray\":[],\"questionId\":14,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'testStudent', '2022-08-26 09:44:25', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (81, 15, 19, 19, 5, 6, 5, 10, '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":81,\"content\":\"略\",\"contentArray\":[],\"questionId\":15,\"doRight\":null,\"itemOrder\":2,\"score\":null}', NULL, 'testStudent', '2022-08-26 09:44:25', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (82, 14, 19, 20, 1, 6, 0, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'B', '{\"epqCustomerAnswerId\":82,\"content\":\"B\",\"contentArray\":[],\"questionId\":14,\"doRight\":false,\"itemOrder\":1,\"score\":null}', b'0', 'testStudent', '2022-08-26 09:44:59', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (83, 15, 19, 20, 5, 6, 9, 10, '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":83,\"content\":\"略\",\"contentArray\":[],\"questionId\":15,\"doRight\":null,\"itemOrder\":2,\"score\":null}', NULL, 'testStudent', '2022-08-26 09:44:59', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (84, 14, 19, 21, 1, 6, 0, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'B', '{\"epqCustomerAnswerId\":84,\"content\":\"B\",\"contentArray\":[],\"questionId\":14,\"doRight\":false,\"itemOrder\":1,\"score\":null}', b'0', 'testStudent', '2022-08-26 10:16:42', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (85, 15, 19, 21, 5, 6, 0, 10, '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":85,\"content\":\"略\",\"contentArray\":[],\"questionId\":15,\"doRight\":null,\"itemOrder\":2,\"score\":null}', NULL, 'testStudent', '2022-08-26 10:16:42', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (86, 14, 19, 22, 1, 6, 0, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'B', '{\"epqCustomerAnswerId\":86,\"content\":\"B\",\"contentArray\":[],\"questionId\":14,\"doRight\":false,\"itemOrder\":1,\"score\":null}', b'0', 'testStudent', '2022-08-26 10:17:59', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (87, 15, 19, 22, 5, 6, 9, 10, '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":87,\"content\":\"略\",\"contentArray\":[],\"questionId\":15,\"doRight\":false,\"itemOrder\":2,\"score\":null}', b'0', 'testStudent', '2022-08-26 10:17:59', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (88, 14, 19, 23, 1, 6, 1, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":88,\"content\":\"A\",\"contentArray\":[],\"questionId\":14,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'testStudent', '2022-08-26 10:21:36', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (89, 15, 19, 23, 5, 6, 10, 10, '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":89,\"content\":\"略\",\"contentArray\":[],\"questionId\":15,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'testStudent', '2022-08-26 10:21:36', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (90, 14, 20, 24, 1, 6, 1, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":90,\"content\":\"A\",\"contentArray\":[],\"questionId\":14,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'studentTest', '2022-08-26 11:00:34', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (91, 15, 20, 24, 5, 6, 9, 10, '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', '略', '{\"epqCustomerAnswerId\":91,\"content\":\"略\",\"contentArray\":[],\"questionId\":15,\"doRight\":false,\"itemOrder\":2,\"score\":null}', b'0', 'studentTest', '2022-08-26 11:00:34', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (92, 11, 22, 25, 1, 6, 2, 2, '{\"analyze\":\"875\",\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":92,\"content\":\"A\",\"contentArray\":[],\"questionId\":11,\"doRight\":true,\"itemOrder\":1,\"score\":null}', b'1', 'studentTest', '2022-08-26 11:04:09', NULL);
INSERT INTO `t_exam_paper_question_customer_answer` VALUES (93, 14, 22, 25, 1, 6, 1, 1, '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'A', '{\"epqCustomerAnswerId\":93,\"content\":\"A\",\"contentArray\":[],\"questionId\":14,\"doRight\":true,\"itemOrder\":2,\"score\":null}', b'1', 'studentTest', '2022-08-26 11:04:09', NULL);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int NULL DEFAULT NULL COMMENT '父菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名字',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端组件所在的位置',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单在前端的路由',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端组件名称',
  `hidden` bit(1) NULL DEFAULT NULL COMMENT '菜单是否隐藏(1.隐藏，0.不隐藏)',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `no_cache` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有缓存(0.为false有缓存，1 为true无缓存)',
  `active_menu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活跃在菜单',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, NULL, '用户管理', 'Layout', '/user', 'UserPage', b'0', 'users', b'1', NULL);
INSERT INTO `t_menu` VALUES (2, NULL, '学科管理', 'Layout', '/education', 'EducationPage', b'0', 'education', b'1', NULL);
INSERT INTO `t_menu` VALUES (3, NULL, '班级管理', 'Layout', '/classManagement', 'ClassPage', b'0', 'form', b'1', NULL);
INSERT INTO `t_menu` VALUES (4, NULL, '卷题管理', 'Layout', '/exam', 'ExamPage', b'0', 'exam', b'1', NULL);
INSERT INTO `t_menu` VALUES (5, NULL, '任务管理', 'Layout', '/task', 'TaskPage', b'0', 'task', b'1', NULL);
INSERT INTO `t_menu` VALUES (6, NULL, '答卷管理', 'Layout', '/answer', 'AnswerPage', b'0', 'answer', b'1', NULL);
INSERT INTO `t_menu` VALUES (7, NULL, '日志中心', 'Layout', '/log', 'LogPage', b'0', 'log', b'1', NULL);
INSERT INTO `t_menu` VALUES (8, 1, '学生列表', 'user/student/list', 'student/list', 'UserStudentPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (9, 1, '学生编辑', 'user/student/edit', 'student/edit', 'UserStudentEdit', b'1', NULL, b'1', '/user/student/list');
INSERT INTO `t_menu` VALUES (10, 1, '老师列表', 'user/teacher/list', 'teacher/list', 'UserTeacherPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (11, 1, '老师编辑', 'user/teacher/edit', 'teacher/edit', 'UserTeacherEdit', b'1', NULL, b'1', '/user/teacher/list');
INSERT INTO `t_menu` VALUES (12, 1, '管理员列表', 'user/admin/list', 'admin/list', 'UserAdminPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (13, 1, '管理员编辑', 'user/admin/edit', 'admin/edit', 'UserAdminEdit', b'1', NULL, b'1', '/user/admin/list');
INSERT INTO `t_menu` VALUES (14, 2, '学科列表', 'education/subject/list', 'subject/list', 'EducationSubjectPage', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (15, 2, '学科编辑', 'education/subject/edit', 'subject/edit', 'EducationSubjectEditPage', b'1', NULL, b'1', '/education/subject/list');
INSERT INTO `t_menu` VALUES (16, 3, '班级列表', 'class/list', 'class/list', 'ClassPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (17, 3, '班级编辑', 'class/edit', 'class/edit', 'ClassPageEdit', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (18, 4, '试卷列表', 'exam/paper/list', 'paper/list', 'ExamPaperPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (19, 4, '试卷编辑', 'exam/paper/edit', 'paper/edit', 'ExamPaperEdit', b'1', NULL, b'1', '/exam/paper/list');
INSERT INTO `t_menu` VALUES (20, 4, '题目列表', 'exam/question/list', 'question/list', 'ExamQuestionPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (21, 4, '单选题编辑', 'exam/question/edit/single-choice', 'question/edit/singleChoice', 'singleChoicePage', b'1', NULL, b'1', '/exam/question/list');
INSERT INTO `t_menu` VALUES (22, 4, '多选题编辑', 'exam/question/edit/multiple-choice', 'question/edit/multipleChoice', 'multipleChoicePage', b'1', NULL, b'1', '/exam/question/list');
INSERT INTO `t_menu` VALUES (23, 4, '判断题编辑', 'exam/question/edit/true-false', 'question/edit/trueFalse', 'trueFalsePage', b'1', NULL, b'1', '/exam/question/list');
INSERT INTO `t_menu` VALUES (24, 4, '填空题编辑', 'exam/question/edit/gap-filling', 'question/edit/gapFilling', 'gapFillingPage', b'1', NULL, b'1', '/exam/question/list');
INSERT INTO `t_menu` VALUES (25, 4, '简答题编辑', 'exam/question/edit/short-answer', 'question/edit/shortAnswer', 'shortAnswerPage', b'1', NULL, b'1', '/exam/question/list');
INSERT INTO `t_menu` VALUES (26, 5, '任务列表', 'task/list', 'list', 'TaskListPage', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (27, 5, '任务创建', 'task/edit', 'edit', 'TaskEditPage', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (28, 6, '批改完成列表', 'answer/list', 'list', 'AnswerPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (29, 6, '批改列表', 'answer/correcting', 'correcting', 'CorrectPageList', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (30, 7, '用户日志', 'log/list', 'user/list', 'LogUserPage', b'0', NULL, b'1', NULL);
INSERT INTO `t_menu` VALUES (31, 6, '已答试卷', 'answer/read', 'read', 'ReadAnswerPage', b'1', NULL, b'1', '/answer/list');
INSERT INTO `t_menu` VALUES (32, 6, '打印已答试卷', 'answer/print', 'print', 'PrintAnswerPage', b'1', NULL, b'1', '/answer/list');
INSERT INTO `t_menu` VALUES (33, 6, '批改已答试卷', 'answer/edit', 'edit', 'CorrectAnswerPage', b'1', NULL, b'1', '/answer/correcting');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL,
  `send_user_id` int NULL DEFAULT NULL COMMENT '发送者用户ID',
  `send_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送者用户名',
  `send_real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送者真实姓名',
  `receive_user_count` int NULL DEFAULT NULL COMMENT '接收人数',
  `read_count` int NULL DEFAULT NULL COMMENT '已读人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_message_user
-- ----------------------------
DROP TABLE IF EXISTS `t_message_user`;
CREATE TABLE `t_message_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `message_id` int NULL DEFAULT NULL COMMENT '消息内容ID',
  `receive_user_id` int NULL DEFAULT NULL COMMENT '接收人ID',
  `receive_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收人用户名',
  `receive_real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收人真实姓名',
  `readed` bit(1) NULL DEFAULT NULL COMMENT '是否已读',
  `create_time` datetime NULL DEFAULT NULL,
  `read_time` datetime NULL DEFAULT NULL COMMENT '阅读时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_message_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_type` int NULL DEFAULT NULL COMMENT '1.单选题 2.多选题 3.判断题 4.填空题 5.简答题',
  `subject_id` int NULL DEFAULT NULL COMMENT '学科',
  `score` int NULL DEFAULT NULL COMMENT '题目总分(千分制)',
  `grade_level` int NULL DEFAULT NULL COMMENT '级别',
  `difficult` int NULL DEFAULT NULL COMMENT '题目难度',
  `correct` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '正确答案',
  `text_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '题目 填空、 题干、解析等信息',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `status` int NULL DEFAULT NULL COMMENT '1.正常',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES (1, 1, 2, 2, 1, 1, 'C', '{\"analyze\":\"1+1=2\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'admin', NULL, '2022-06-21 15:03:56', b'0');
INSERT INTO `t_question` VALUES (2, 3, 2, 1, 1, 1, 'A', '{\"analyze\":\"1+1=2\",\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'admin', NULL, '2022-06-21 15:36:08', b'0');
INSERT INTO `t_question` VALUES (3, 5, 3, 10, 1, 3, '　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!\n　　我要多看书，故事真有意思!', '{\"analyze\":\"　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!\\n　　我要多看书，故事真有意思!\",\"title\":\"写观看西游记的读后感，要求三百字以内。\",\"items\":[]}', 'admin', NULL, '2022-06-21 16:15:29', b'0');
INSERT INTO `t_question` VALUES (4, 5, 2, 10, 1, 3, '啊士大夫大撒旦发射点发射点发', '{\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[]}', 'admin', NULL, '2022-06-21 19:51:12', b'0');
INSERT INTO `t_question` VALUES (5, 4, 2, 1, 1, 1, 'b', '{\"analyze\":\"abcd\",\"title\":\"填空：a____c\",\"items\":[{\"prefix\":\"a____c\",\"content\":\"\",\"id\":null}]}', 'admin', NULL, '2022-06-21 20:20:14', b'0');
INSERT INTO `t_question` VALUES (6, 1, 5, 2, 2, 1, 'A', '{\"analyze\":\"da xiao\",\"title\":\"大小的拼音？\",\"items\":[{\"prefix\":\"A\",\"content\":\"da xiao\",\"id\":null},{\"prefix\":\"B\",\"content\":\"da xi\",\"id\":null},{\"prefix\":\"C\",\"content\":\"da da\",\"id\":null},{\"prefix\":\"D\",\"content\":\"da xia\",\"id\":null}]}', 'admin', NULL, '2022-06-22 19:05:50', b'0');
INSERT INTO `t_question` VALUES (7, 1, 2, 1, 1, 1, 'B', '{\"analyze\":\"<p>略</p>\",\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}]}', 'admin', NULL, '2022-07-13 16:00:31', b'0');
INSERT INTO `t_question` VALUES (8, 2, 2, 2, 1, 1, '[\"B\",\"D\"]', '{\"analyze\":\"略\",\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}]}', 'admin', NULL, '2022-07-13 16:03:42', b'0');
INSERT INTO `t_question` VALUES (9, 2, 2, 3, 1, 1, '[\"A\",\"B\"]', '{\"analyze\":\"<p>略</p>\",\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}]}', 'admin', NULL, '2022-07-13 16:24:31', b'0');
INSERT INTO `t_question` VALUES (10, 1, 5, 2, 2, 3, 'A', '{\"analyze\":\"四大名著是：西游记、红楼梦、三国演义、水浒传\",\"title\":\"下面哪个是四大名著之一？\",\"items\":[{\"prefix\":\"A\",\"content\":\"西游记\",\"id\":null},{\"prefix\":\"B\",\"content\":\"百年孤独\",\"id\":null},{\"prefix\":\"C\",\"content\":\"挪威的森林\",\"id\":null},{\"prefix\":\"D\",\"content\":\"斗罗大陆\",\"id\":null}]}', 'admin', NULL, '2022-08-24 19:23:33', b'0');
INSERT INTO `t_question` VALUES (11, 1, 6, 2, 2, 2, 'A', '{\"analyze\":\"875\",\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}]}', 'zhanglaoshi', NULL, '2022-08-25 15:55:36', b'0');
INSERT INTO `t_question` VALUES (12, 3, 6, 2, 2, 2, 'A', '{\"analyze\":\"对\",\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}]}', 'zhanglaoshi', NULL, '2022-08-25 15:56:59', b'0');
INSERT INTO `t_question` VALUES (13, 5, 6, 10, 2, 4, '因为1+1=2，所以1+1=2', '{\"analyze\":\"因为1+1=2，所以1+1=2\",\"title\":\"求证1+1=2\",\"items\":[]}', 'zhanglaoshi', NULL, '2022-08-25 16:23:13', b'0');
INSERT INTO `t_question` VALUES (14, 1, 6, 1, 2, 2, 'A', '{\"analyze\":\"100\",\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}]}', 'testTeacher', NULL, '2022-08-26 09:29:20', b'0');
INSERT INTO `t_question` VALUES (15, 5, 6, 10, 2, 4, '略', '{\"analyze\":\"略\",\"title\":\"有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？\",\"items\":[]}', 'testTeacher', NULL, '2022-08-26 09:31:10', b'0');
INSERT INTO `t_question` VALUES (16, 1, 6, 2, 2, 2, 'A', '{\"analyze\":\"3\",\"title\":\"1+2=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"4\",\"id\":null},{\"prefix\":\"C\",\"content\":\"5\",\"id\":null},{\"prefix\":\"D\",\"content\":\"6\",\"id\":null}]}', 'teacherTest', NULL, '2022-08-26 10:51:19', b'0');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` int NULL DEFAULT NULL,
  `menu_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 2, 1);
INSERT INTO `t_role_menu` VALUES (2, 2, 2);
INSERT INTO `t_role_menu` VALUES (3, 2, 3);
INSERT INTO `t_role_menu` VALUES (4, 2, 4);
INSERT INTO `t_role_menu` VALUES (5, 2, 6);
INSERT INTO `t_role_menu` VALUES (6, 2, 8);
INSERT INTO `t_role_menu` VALUES (7, 2, 9);
INSERT INTO `t_role_menu` VALUES (8, 2, 14);
INSERT INTO `t_role_menu` VALUES (9, 2, 15);
INSERT INTO `t_role_menu` VALUES (10, 2, 16);
INSERT INTO `t_role_menu` VALUES (11, 2, 17);
INSERT INTO `t_role_menu` VALUES (12, 2, 18);
INSERT INTO `t_role_menu` VALUES (13, 2, 19);
INSERT INTO `t_role_menu` VALUES (14, 2, 20);
INSERT INTO `t_role_menu` VALUES (15, 2, 21);
INSERT INTO `t_role_menu` VALUES (16, 2, 22);
INSERT INTO `t_role_menu` VALUES (17, 2, 23);
INSERT INTO `t_role_menu` VALUES (18, 2, 24);
INSERT INTO `t_role_menu` VALUES (19, 2, 25);
INSERT INTO `t_role_menu` VALUES (20, 2, 28);
INSERT INTO `t_role_menu` VALUES (21, 2, 29);
INSERT INTO `t_role_menu` VALUES (22, 2, 31);
INSERT INTO `t_role_menu` VALUES (23, 2, 32);
INSERT INTO `t_role_menu` VALUES (24, 2, 33);

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '语文 数学 英语 等',
  `level` int NULL DEFAULT NULL COMMENT '年级 (1-12) 小学 初中 高中 大学',
  `level_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '一年级、二年级等',
  `item_order` int NULL DEFAULT NULL COMMENT '排序',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES (2, '数学', 1, '一年级', NULL, b'0');
INSERT INTO `t_subject` VALUES (3, '语文', 1, '一年级', NULL, b'0');
INSERT INTO `t_subject` VALUES (4, '英语', 1, '一年级', NULL, b'0');
INSERT INTO `t_subject` VALUES (5, '语文', 2, '二年级', NULL, b'0');
INSERT INTO `t_subject` VALUES (6, '数学', 2, '二年级', NULL, b'0');

-- ----------------------------
-- Table structure for t_task_exam
-- ----------------------------
DROP TABLE IF EXISTS `t_task_exam`;
CREATE TABLE `t_task_exam`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `grade_level` int NULL DEFAULT NULL COMMENT '级别',
  `text_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '任务框架 内容为JSON',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_task_exam
-- ----------------------------
INSERT INTO `t_task_exam` VALUES (1, '国庆各科作业', 1, '[{\"id\":8,\"level\":null,\"subjectId\":3,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":10,\"limitDateTime\":null,\"titleItems\":null,\"name\":\"随堂练习\"}]', 'admin', '2022-06-23 14:57:07', b'1');
INSERT INTO `t_task_exam` VALUES (2, '国庆各科作业', 1, '[{\"id\":8,\"level\":null,\"subjectId\":3,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":10,\"limitDateTime\":null,\"titleItems\":null,\"name\":\"随堂练习\"}]', 'admin', '2022-06-23 14:57:07', b'1');
INSERT INTO `t_task_exam` VALUES (3, '国庆各科作业', 1, '[{\"id\":8,\"level\":null,\"subjectId\":3,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":10,\"limitDateTime\":null,\"titleItems\":null,\"name\":\"随堂练习\"}]', 'admin', '2022-06-23 14:57:07', b'1');
INSERT INTO `t_task_exam` VALUES (4, '课后习题', 1, '[{\"id\":8,\"level\":null,\"subjectId\":3,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":10,\"limitDateTime\":null,\"titleItems\":null,\"name\":\"随堂练习\"}]', 'admin', '2022-07-07 18:26:00', b'1');
INSERT INTO `t_task_exam` VALUES (5, '课后习题', 1, '[{\"id\":8,\"level\":1,\"subjectId\":3,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":null,\"suggestTime\":10,\"limitDateTime\":[null,null],\"titleItems\":[{\"name\":\"简答题\",\"questionItems\":[{\"id\":3,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":3,\"title\":\"<p style=\\\"text-align: left;\\\">写观看西游记的读后感，要求三百字以内。</p>\",\"items\":[],\"analyze\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"correct\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null}]}],\"name\":\"随堂练习\"}]', 'admin', '2022-07-07 19:01:15', b'1');
INSERT INTO `t_task_exam` VALUES (6, '暑假作业', 1, '[{\"id\":8,\"level\":1,\"subjectId\":3,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":null,\"suggestTime\":10,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"简答题\",\"questionItems\":[{\"id\":3,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":3,\"title\":\"<p style=\\\"text-align: left;\\\">写观看西游记的读后感，要求三百字以内。</p>\",\"items\":[],\"analyze\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"correct\":\"<span style=\\\"background-color: #FFFFFF; color: #333333; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif;\\\">我看《西游记》，西游记真是一个很有意思的故事啊，讲的是唐僧、孙悟空、猪八戒还有沙和尚，还有白龙马呢，一起西天取经的故事。妈妈说孙悟空和猪八戒都是从天上下来的，孙悟空被压在石头山下，猪八戒以前是元帅，后来就变成了猪!太有意思了!为什么这么多的妖怪呢，现在没有妖怪了呢。</span><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我叫妈妈给我讲，为什么要取经呢，去哪里取呢?妈妈说是以前的一个和尚，取印度取经。妖怪多是因为吃了唐僧肉，就可以长生不老!</p><p style=\\\"margin-top: 0px; margin-bottom: 10px; padding: 0px; color: rgb(51, 51, 51); overflow-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;, SimSun, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\\\">　　我要多看书，故事真有意思!</p>\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"随堂练习\",\"score\":null}]', 'admin', '2022-07-13 09:45:39', b'1');
INSERT INTO `t_task_exam` VALUES (7, '国庆作业', 1, '{\"id\":11,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":\"\",\"score\":0,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务1\",\"score\":null}', 'admin', '2022-07-13 16:05:17', b'1');
INSERT INTO `t_task_exam` VALUES (8, '五一作业', 1, '[{\"id\":11,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":\"\",\"score\":0,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务1\",\"score\":null}]', 'admin', '2022-07-13 17:02:59', b'1');
INSERT INTO `t_task_exam` VALUES (9, '假期作业1', 1, '[{\"id\":12,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":null,\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null},{\"id\":9,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":null,\"score\":3,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"A\",\"B\"],\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":2,\"questionType\":3,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"A\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务\",\"score\":null}]', 'admin', '2022-07-13 17:46:52', b'1');
INSERT INTO `t_task_exam` VALUES (10, '国庆作业', 1, '[{\"id\":12,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":null,\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null},{\"id\":9,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":null,\"score\":3,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"A\",\"B\"],\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":2,\"questionType\":3,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"A\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务\",\"score\":null,\"examPaperAnswerId\":6}]', 'admin', '2022-07-14 15:18:12', b'1');
INSERT INTO `t_task_exam` VALUES (11, '假期作业', 1, '[{\"id\":12,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":null,\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null},{\"id\":9,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":null,\"score\":3,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"A\",\"B\"],\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":2,\"questionType\":3,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"A\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务\",\"score\":null,\"examPaperAnswerId\":7}]', 'admin', '2022-07-14 16:32:12', b'1');
INSERT INTO `t_task_exam` VALUES (12, '假期作业', 1, '[{\"id\":12,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":2,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":null,\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null},{\"id\":9,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数相加等于5的是？<br/>\",\"items\":[{\"prefix\":\"A\",\"content\":\"1+4\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2+3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1+2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"3+3\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":null,\"score\":3,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"A\",\"B\"],\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":2,\"questionType\":3,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=2\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"A\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务\",\"score\":null,\"examPaperAnswerId\":8}]', 'admin', '2022-07-14 16:34:15', b'1');
INSERT INTO `t_task_exam` VALUES (13, '五一作业', 1, '[{\"id\":11,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":1,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":\"\",\"score\":0,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务1\",\"score\":null,\"examPaperAnswerId\":9}]', 'admin', '2022-07-14 20:25:30', b'1');
INSERT INTO `t_task_exam` VALUES (14, '五一作业', 1, '[{\"id\":11,\"level\":1,\"subjectId\":2,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":2,\"suggestTime\":100,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":1,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3\",\"id\":null},{\"prefix\":\"C\",\"content\":\"2\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"1+1=2\",\"correct\":\"C\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":7,\"questionType\":1,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"1+1=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"1\",\"id\":null},{\"prefix\":\"B\",\"content\":\"2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"3\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4\",\"id\":null}],\"analyze\":\"<p>略</p>\",\"correct\":\"B\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"多选题\",\"questionItems\":[{\"id\":8,\"questionType\":2,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"下面算数等于1的是？\",\"items\":[{\"prefix\":\"A\",\"content\":\"3-3\",\"id\":null},{\"prefix\":\"B\",\"content\":\"3-2\",\"id\":null},{\"prefix\":\"C\",\"content\":\"1-1\",\"id\":null},{\"prefix\":\"D\",\"content\":\"4-3\",\"id\":null}],\"analyze\":\"略\",\"correct\":\"\",\"score\":0,\"difficult\":1,\"createUser\":null,\"correctArray\":[\"B\",\"D\"],\"itemOrder\":null}]},{\"name\":\"填空题\",\"questionItems\":[{\"id\":5,\"questionType\":4,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"<span class=\\\"gapfilling-span \\\">a()c</span>\",\"items\":[{\"prefix\":\"a()c\",\"content\":\"b\",\"id\":null}],\"analyze\":\"abcd\",\"correct\":\"b\",\"score\":1,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"简答题\",\"questionItems\":[{\"id\":4,\"questionType\":5,\"gradeLevel\":1,\"subjectId\":2,\"title\":\"画出正方形、长方形、圆形、三角形。\",\"items\":[],\"analyze\":\"阿斯顿发大水发射点噶撒旦发射点\",\"correct\":\"啊士大夫大撒旦发射点发射点发\",\"score\":10,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务1\",\"score\":null,\"examPaperAnswerId\":10}]', 'admin', '2022-07-14 20:31:16', b'0');
INSERT INTO `t_task_exam` VALUES (15, '二年级任务', 2, '[{\"id\":13,\"level\":2,\"subjectId\":5,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":null,\"suggestTime\":20,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"拼音\",\"questionItems\":[{\"id\":6,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"<p>大小的拼音？</p>\",\"items\":[{\"prefix\":\"A\",\"content\":\"da xiao\",\"id\":null},{\"prefix\":\"B\",\"content\":\"da xi\",\"id\":null},{\"prefix\":\"C\",\"content\":\"da da\",\"id\":null},{\"prefix\":\"D\",\"content\":\"da xia\",\"id\":null}],\"analyze\":\"da xiao\",\"correct\":\"A\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"二年级语文试卷1\",\"score\":null,\"examPaperAnswerId\":null}]', 'admin', '2022-08-20 10:51:03', b'0');
INSERT INTO `t_task_exam` VALUES (16, '任务模拟1', 2, '[{\"id\":18,\"level\":2,\"subjectId\":6,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":2,\"suggestTime\":20,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":11,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}],\"analyze\":\"875\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]},{\"name\":\"判断题\",\"questionItems\":[{\"id\":12,\"questionType\":3,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=875\",\"items\":[{\"prefix\":\"A\",\"content\":\"是\",\"id\":null},{\"prefix\":\"B\",\"content\":\"否\",\"id\":null}],\"analyze\":\"对\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"任务试卷1\",\"score\":null,\"examPaperAnswerId\":15}]', 'admin', '2022-08-25 16:00:59', b'0');
INSERT INTO `t_task_exam` VALUES (17, '国庆作业', 2, '[{\"id\":22,\"level\":2,\"subjectId\":6,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":2,\"suggestTime\":20,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":11,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"25×35=？\",\"items\":[{\"prefix\":\"A\",\"content\":\"875\",\"id\":null},{\"prefix\":\"B\",\"content\":\"877\",\"id\":null},{\"prefix\":\"C\",\"content\":\"888\",\"id\":null},{\"prefix\":\"D\",\"content\":\"675\",\"id\":null}],\"analyze\":\"875\",\"correct\":\"A\",\"score\":2,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":14,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":6,\"title\":\"20+80=?\",\"items\":[{\"prefix\":\"A\",\"content\":\"100\",\"id\":null},{\"prefix\":\"B\",\"content\":\"200\",\"id\":null},{\"prefix\":\"C\",\"content\":\"150\",\"id\":null},{\"prefix\":\"D\",\"content\":\"160\",\"id\":null}],\"analyze\":\"100\",\"correct\":\"A\",\"score\":1,\"difficult\":2,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"二年级任务试卷1\",\"score\":null,\"examPaperAnswerId\":25},{\"id\":23,\"level\":2,\"subjectId\":5,\"pageIndex\":null,\"pageSize\":null,\"paperType\":6,\"status\":2,\"suggestTime\":20,\"limitDateTime\":[\"\",\"\"],\"titleItems\":[{\"name\":\"单选题\",\"questionItems\":[{\"id\":10,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"下面哪个是四大名著之一？\",\"items\":[{\"prefix\":\"A\",\"content\":\"西游记\",\"id\":null},{\"prefix\":\"B\",\"content\":\"百年孤独\",\"id\":null},{\"prefix\":\"C\",\"content\":\"挪威的森林\",\"id\":null},{\"prefix\":\"D\",\"content\":\"斗罗大陆\",\"id\":null}],\"analyze\":\"四大名著是：西游记、红楼梦、三国演义、水浒传\",\"correct\":\"A\",\"score\":2,\"difficult\":3,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null},{\"id\":6,\"questionType\":1,\"gradeLevel\":2,\"subjectId\":5,\"title\":\"大小的拼音？\",\"items\":[{\"prefix\":\"A\",\"content\":\"da xiao\",\"id\":null},{\"prefix\":\"B\",\"content\":\"da xi\",\"id\":null},{\"prefix\":\"C\",\"content\":\"da da\",\"id\":null},{\"prefix\":\"D\",\"content\":\"da xia\",\"id\":null}],\"analyze\":\"da xiao\",\"correct\":\"A\",\"score\":2,\"difficult\":1,\"createUser\":null,\"correctArray\":null,\"itemOrder\":null}]}],\"name\":\"二年级语文任务试卷\",\"score\":null,\"examPaperAnswerId\":25}]', 'admin', '2022-08-26 11:03:56', b'0');

-- ----------------------------
-- Table structure for t_task_exam_customer_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_task_exam_customer_answer`;
CREATE TABLE `t_task_exam_customer_answer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `task_exam_id` int NULL DEFAULT NULL,
  `create_user` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `text_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '任务完成情况(Json)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_task_exam_customer_answer
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `age` int NULL DEFAULT NULL,
  `sex` int NULL DEFAULT NULL COMMENT '1.男 2女',
  `birth_day` datetime NULL DEFAULT NULL,
  `user_level` int NULL DEFAULT NULL COMMENT '学生年级(1-12)',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` int NOT NULL COMMENT '1.学生 2.老师 3.管理员',
  `status` int NOT NULL DEFAULT 1 COMMENT '1.启用 2禁用',
  `image_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_active_time` datetime NOT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `class_id` int NOT NULL DEFAULT 0 COMMENT '班级id',
  `wx_open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'd2d29da2-dcb3-4013-b874-727626236f47', 'student', '$2a$10$uxPACLc7onGmyxChnV04LeClIkMCNYHY1HEGX7UIhaChEiTr4VW8i', '学生', 18, 1, '2000-10-31 08:00:00', 1, '13382512032', 1, 1, 'http://localhost:81/updateImages/7afbee7c-0691-4750-be12-773b7028ae2d.jpg', '2019-09-07 18:55:02', '2022-08-26 10:48:10', '2022-07-21 17:26:28', b'0', 11, NULL);
INSERT INTO `t_user` VALUES (2, '52045f5f-a13f-4ccc-93dd-f7ee8270ad4c', 'admin', '$2a$10$uxPACLc7onGmyxChnV04LeClIkMCNYHY1HEGX7UIhaChEiTr4VW8i', '管理员', 30, 1, '2000-10-31 08:00:00', NULL, '13382512032', 3, 1, NULL, '2019-09-07 18:56:21', '2022-08-15 19:50:08', '2022-08-15 19:50:08', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (6, '642c7547-cecd-492b-8d6e-fbe74e5669d1', 'teacher', '$2a$10$CyrbsbCuNZQkRTMfUXa8rOnbeEMrlkr7UXelePMM00BDzPhhEnwf.', '老师', 40, 1, '2022-06-02 08:00:00', 2, '1234567890', 2, 1, NULL, '2022-06-14 11:30:54', '2022-07-08 20:17:06', '2022-06-14 11:30:54', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (10, '3f17d387-9d2f-4d38-bf27-9b82829bc611', '1902210035', '$2a$10$UN0Rm5VSVppd3Mka6TAI5.ki22ca3J3f51qFnTJXCnwupt09kh1vG', NULL, NULL, NULL, NULL, 1, NULL, 1, 1, NULL, '2022-07-08 16:34:58', '2022-07-08 20:17:07', '2022-07-08 16:34:58', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (12, '27713372-9dbb-4993-be98-607eee29ad65', 'caoaxin', '$2a$10$V7udqwQd1VBN7la/fMzARu.BMTC8rstpZLjJ1q4bKzVmWbHJOYdqO', '曹阿鑫', 22, 1, '2000-10-31 08:00:00', 1, '13382512032', 2, 1, NULL, '2022-08-20 14:41:08', '2022-08-20 14:41:08', '2022-08-20 14:41:08', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (13, 'f3b7c875-c18f-4d82-9ec3-f812393ad125', 'aazaaa', '$2a$10$nu.oevW3D9BdujRbqOY08u39ShuJoHZxLN05LXC/loiBu.zGanD/S', NULL, NULL, NULL, NULL, 1, NULL, 1, 1, NULL, '2022-08-24 09:20:03', '2022-08-24 09:20:42', '2022-08-24 09:20:03', b'0', 11, NULL);
INSERT INTO `t_user` VALUES (14, '5447c4e4-c127-41ab-a660-8911e55445d9', 'zhanglaoshi', '$2a$10$.KWvqI7f84IsiCAzmT4Iye59NfSoEiaIkbYpjC8.UbQbpVPeOJtiC', '曹阿鑫', 25, 1, '2000-06-06 08:00:00', 2, '13382512032', 2, 1, NULL, '2022-08-25 15:51:25', '2022-08-25 15:51:25', '2022-08-25 15:51:25', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (15, '11da5df8-19d1-4f88-8925-f4882c6f7d7a', 'zhangStudent', '$2a$10$4cj6bH7ErcfPF6tR73rhJOts9fu1DHFkkUomZs1JYdzzVzfh/DueO', '曹阿鑫2', 15, 1, '2007-06-05 08:00:00', 2, '13382512032', 1, 1, 'http://localhost:81/updateImages/f26d61d9-c1a4-4293-9c16-9128f4c642f1.jpg', '2022-08-25 16:01:45', '2022-08-25 16:17:51', '2022-08-25 16:01:45', b'0', 12, NULL);
INSERT INTO `t_user` VALUES (16, 'f4288e79-9d8b-430a-a715-9fe29d7eb15d', 'testTeacher', '$2a$10$3T.k/u6X2nC3zrNKGCgEDupddkHv.YmNi5hdHhEj6FVltneLuTSBq', '曹阿鑫s', 35, 1, '1988-06-07 09:00:00', 2, '13382512032', 2, 1, NULL, '2022-08-26 09:09:36', '2022-08-26 09:09:36', '2022-08-26 09:09:36', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (17, '54174505-d110-4851-8920-69eb6cdf83ec', 'testStudent', '$2a$10$GFOtop54n7QYkblHgv6uFexop27DlqgiD2igfUFsGkZsEkh2LscvG', '曹阿鑫1', 15, 1, '2007-06-07 08:00:00', 2, '', 1, 1, 'http://localhost:81/updateImages/0efe9f7b-75ec-4a8b-b0fc-adfd983198bd.jpg', '2022-08-26 09:32:34', '2022-08-26 09:43:26', '2022-08-26 09:32:34', b'0', 13, NULL);
INSERT INTO `t_user` VALUES (18, '063a7e25-4bc3-4f55-8784-0e76bcd3077e', 'testStudent1', '$2a$10$UnfLNUaVlrE9/dIxAEJkFOoZOdvBreHkaJ5ZoOqPUR2QVRPQv7AsW', NULL, NULL, NULL, NULL, 2, NULL, 1, 1, NULL, '2022-08-26 09:37:13', '2022-08-26 09:37:13', '2022-08-26 09:37:13', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (19, 'f572dbf1-ea0e-45c4-92f5-eeb35b1dced7', 'testStudent2', '$2a$10$rxibVPQGx76c/7QeW3kuOuISSBoxho5A3/ZMw4WhZwkb0gK46Mcwu', NULL, NULL, NULL, NULL, 2, NULL, 1, 1, NULL, '2022-08-26 09:37:57', '2022-08-26 09:37:57', '2022-08-26 09:37:57', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (20, 'b010adca-f41c-4f2c-9c1c-05b19d96810d', 'testStudent3', '$2a$10$NuLh6jTIOwH1t0avV3oPF.iO.Wi3G6yPiAyXeW9g8bQPIH5PFHfMG', NULL, NULL, NULL, NULL, 1, NULL, 1, 1, NULL, '2022-08-26 10:24:48', '2022-08-26 10:24:48', '2022-08-26 10:24:48', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (21, '665e5c45-cbc7-46bc-b542-803b4efadd62', 'teacherTest', '$2a$10$FxzoHXkq3/XUv/bfbJenq.c9D95alFaJEpSEjCy2QoiCjeLgyd3iO', '曹阿鑫ss', 25, 1, '1997-06-10 08:00:00', 2, '13382512032', 2, 1, NULL, '2022-08-26 10:49:04', '2022-08-26 10:49:04', '2022-08-26 10:49:04', b'0', 0, NULL);
INSERT INTO `t_user` VALUES (22, 'a5eddcd5-0f40-436b-9e5c-8ebfff86d372', 'studentTest', '$2a$10$wy81Fo/jdEmhFAw2Eelc/edWk365rlOWgbM010TV3UEYpzDE6cqsi', '曹阿鑫2', 15, 1, '2007-06-07 08:00:00', 2, '', 1, 1, NULL, '2022-08-26 10:52:03', '2022-08-26 10:53:09', '2022-08-26 10:52:03', b'0', 14, NULL);

-- ----------------------------
-- Table structure for t_user_event_log
-- ----------------------------
DROP TABLE IF EXISTS `t_user_event_log`;
CREATE TABLE `t_user_event_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 298 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_user_event_log
-- ----------------------------
INSERT INTO `t_user_event_log` VALUES (1, 2, 'admin', '管理员', 'admin 登录了学之思开源考试系统', '2022-05-19 20:00:29');
INSERT INTO `t_user_event_log` VALUES (2, 2, 'admin', '管理员', 'admin 登录了学之思开源考试系统', '2022-05-19 20:00:37');
INSERT INTO `t_user_event_log` VALUES (3, 1, 'student', '学生', 'student 登录了学之思开源考试系统', '2022-05-19 20:00:48');
INSERT INTO `t_user_event_log` VALUES (4, 2, 'admin', '管理员', 'admin 登录了学之思开源考试系统', '2022-05-19 20:01:22');
INSERT INTO `t_user_event_log` VALUES (5, 1, 'student', '学生', 'student 登录了学之思开源考试系统', '2022-05-24 15:20:09');
INSERT INTO `t_user_event_log` VALUES (6, 2, 'admin', '管理员', 'admin 登录了学之思开源考试系统', '2022-05-24 15:20:16');
INSERT INTO `t_user_event_log` VALUES (7, 1, 'student', '学生', 'student 登录了学之思开源考试系统', '2022-05-24 15:21:50');
INSERT INTO `t_user_event_log` VALUES (8, 1, 'student', '学生', 'student 登出了学之思开源考试系统', '2022-05-24 15:25:22');
INSERT INTO `t_user_event_log` VALUES (9, 2, 'admin', '管理员', 'admin 登录了学之思开源考试系统', '2022-05-24 15:44:18');
INSERT INTO `t_user_event_log` VALUES (10, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 16:30:53');
INSERT INTO `t_user_event_log` VALUES (11, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 16:40:44');
INSERT INTO `t_user_event_log` VALUES (12, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 17:23:54');
INSERT INTO `t_user_event_log` VALUES (13, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 17:37:01');
INSERT INTO `t_user_event_log` VALUES (14, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 17:37:21');
INSERT INTO `t_user_event_log` VALUES (15, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 17:38:38');
INSERT INTO `t_user_event_log` VALUES (16, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 17:39:11');
INSERT INTO `t_user_event_log` VALUES (17, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:19:27');
INSERT INTO `t_user_event_log` VALUES (18, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:32:53');
INSERT INTO `t_user_event_log` VALUES (19, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:33:09');
INSERT INTO `t_user_event_log` VALUES (20, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:47:40');
INSERT INTO `t_user_event_log` VALUES (21, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:49:22');
INSERT INTO `t_user_event_log` VALUES (22, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:49:46');
INSERT INTO `t_user_event_log` VALUES (23, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:51:13');
INSERT INTO `t_user_event_log` VALUES (24, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:54:39');
INSERT INTO `t_user_event_log` VALUES (25, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 19:57:20');
INSERT INTO `t_user_event_log` VALUES (26, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:00:29');
INSERT INTO `t_user_event_log` VALUES (27, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:00:33');
INSERT INTO `t_user_event_log` VALUES (28, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:02:00');
INSERT INTO `t_user_event_log` VALUES (29, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:02:20');
INSERT INTO `t_user_event_log` VALUES (30, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:04:38');
INSERT INTO `t_user_event_log` VALUES (31, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:15:29');
INSERT INTO `t_user_event_log` VALUES (32, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:16:22');
INSERT INTO `t_user_event_log` VALUES (33, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:17:10');
INSERT INTO `t_user_event_log` VALUES (34, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:17:56');
INSERT INTO `t_user_event_log` VALUES (35, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:21:39');
INSERT INTO `t_user_event_log` VALUES (36, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:23:36');
INSERT INTO `t_user_event_log` VALUES (37, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:24:09');
INSERT INTO `t_user_event_log` VALUES (38, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:24:52');
INSERT INTO `t_user_event_log` VALUES (39, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:27:36');
INSERT INTO `t_user_event_log` VALUES (40, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:29:39');
INSERT INTO `t_user_event_log` VALUES (41, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:31:11');
INSERT INTO `t_user_event_log` VALUES (42, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:32:29');
INSERT INTO `t_user_event_log` VALUES (43, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:35:28');
INSERT INTO `t_user_event_log` VALUES (44, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:35:36');
INSERT INTO `t_user_event_log` VALUES (45, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:38:11');
INSERT INTO `t_user_event_log` VALUES (46, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:40:33');
INSERT INTO `t_user_event_log` VALUES (47, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-13 20:44:44');
INSERT INTO `t_user_event_log` VALUES (48, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-14 10:05:57');
INSERT INTO `t_user_event_log` VALUES (49, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 14:43:28');
INSERT INTO `t_user_event_log` VALUES (50, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 16:01:06');
INSERT INTO `t_user_event_log` VALUES (51, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 16:07:36');
INSERT INTO `t_user_event_log` VALUES (52, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 17:24:38');
INSERT INTO `t_user_event_log` VALUES (53, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 19:09:36');
INSERT INTO `t_user_event_log` VALUES (54, 2, 'admin', '管理员', 'admin退出了考试通系统', '2022-06-17 19:09:42');
INSERT INTO `t_user_event_log` VALUES (55, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 19:16:20');
INSERT INTO `t_user_event_log` VALUES (56, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-17 20:06:23');
INSERT INTO `t_user_event_log` VALUES (57, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-21 09:17:08');
INSERT INTO `t_user_event_log` VALUES (58, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-21 14:56:07');
INSERT INTO `t_user_event_log` VALUES (59, 2, 'admin', '管理员', 'admin用户删除题目，id为2', '2022-06-21 16:36:40');
INSERT INTO `t_user_event_log` VALUES (60, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:课后习题', '2022-06-21 17:17:02');
INSERT INTO `t_user_event_log` VALUES (61, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:课后习题', '2022-06-21 17:56:53');
INSERT INTO `t_user_event_log` VALUES (62, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:课后习题', '2022-06-21 17:57:41');
INSERT INTO `t_user_event_log` VALUES (63, 2, 'admin', '管理员', 'admin更新了课后习题2试卷', '2022-06-21 18:39:37');
INSERT INTO `t_user_event_log` VALUES (64, 2, 'admin', '管理员', 'admin更新了课后习题2试卷', '2022-06-21 19:03:28');
INSERT INTO `t_user_event_log` VALUES (65, 2, 'admin', '管理员', 'admin更新了课后习题2试卷', '2022-06-21 19:34:02');
INSERT INTO `t_user_event_log` VALUES (66, 2, 'admin', '管理员', 'admin更新了课后习题2试卷', '2022-06-21 19:34:37');
INSERT INTO `t_user_event_log` VALUES (67, 2, 'admin', '管理员', 'admin更新了课后习题2试卷', '2022-06-21 19:43:42');
INSERT INTO `t_user_event_log` VALUES (68, 2, 'admin', '管理员', 'admin创建了一个简答题,题干:画出正方形、长方形、圆形、三角形。', '2022-06-21 19:51:12');
INSERT INTO `t_user_event_log` VALUES (69, 2, 'admin', '管理员', 'admin更新了课后习题2试卷', '2022-06-21 19:51:41');
INSERT INTO `t_user_event_log` VALUES (70, 2, 'admin', '管理员', 'admin创建了一个填空题,题干:<span class=\"gapfilling-span \">a()c</span>', '2022-06-21 20:20:14');
INSERT INTO `t_user_event_log` VALUES (71, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-22 17:03:22');
INSERT INTO `t_user_event_log` VALUES (72, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-22 18:41:46');
INSERT INTO `t_user_event_log` VALUES (73, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-22 18:58:07');
INSERT INTO `t_user_event_log` VALUES (74, 2, 'admin', '管理员', 'admin创建了一个单选题,题干:<p>大小的拼音？</p>', '2022-06-22 19:05:50');
INSERT INTO `t_user_event_log` VALUES (75, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:随堂练习', '2022-06-22 19:06:26');
INSERT INTO `t_user_event_log` VALUES (76, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-22 20:35:20');
INSERT INTO `t_user_event_log` VALUES (77, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-23 14:22:45');
INSERT INTO `t_user_event_log` VALUES (78, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:国庆作业', '2022-06-23 14:43:43');
INSERT INTO `t_user_event_log` VALUES (79, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:国庆作业', '2022-06-23 14:56:41');
INSERT INTO `t_user_event_log` VALUES (80, 2, 'admin', '管理员', 'admin创建一个个任务为国庆各科作业', '2022-06-23 14:57:07');
INSERT INTO `t_user_event_log` VALUES (81, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-23 17:33:41');
INSERT INTO `t_user_event_log` VALUES (82, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-06-23 18:20:50');
INSERT INTO `t_user_event_log` VALUES (83, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-01 09:05:46');
INSERT INTO `t_user_event_log` VALUES (84, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-01 09:47:43');
INSERT INTO `t_user_event_log` VALUES (85, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-03 15:22:57');
INSERT INTO `t_user_event_log` VALUES (86, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-06 08:24:05');
INSERT INTO `t_user_event_log` VALUES (87, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-06 09:01:27');
INSERT INTO `t_user_event_log` VALUES (88, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:课后习题1', '2022-07-06 09:03:03');
INSERT INTO `t_user_event_log` VALUES (89, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:随堂练习', '2022-07-06 09:16:15');
INSERT INTO `t_user_event_log` VALUES (90, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-06 10:24:39');
INSERT INTO `t_user_event_log` VALUES (91, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-06 14:47:37');
INSERT INTO `t_user_event_log` VALUES (92, 2, 'admin', '管理员', 'admin修改了任务国庆各科作业', '2022-07-06 15:10:10');
INSERT INTO `t_user_event_log` VALUES (93, 2, 'admin', '管理员', 'admin修改了任务国庆各科作业', '2022-07-06 15:11:43');
INSERT INTO `t_user_event_log` VALUES (94, 2, 'admin', '管理员', 'admin修改了任务国庆各科作业', '2022-07-06 15:16:18');
INSERT INTO `t_user_event_log` VALUES (95, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-06 16:23:48');
INSERT INTO `t_user_event_log` VALUES (96, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-06 16:24:53');
INSERT INTO `t_user_event_log` VALUES (97, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-07 16:05:51');
INSERT INTO `t_user_event_log` VALUES (98, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:36:55');
INSERT INTO `t_user_event_log` VALUES (99, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:48:55');
INSERT INTO `t_user_event_log` VALUES (100, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:48:57');
INSERT INTO `t_user_event_log` VALUES (101, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:49:12');
INSERT INTO `t_user_event_log` VALUES (102, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:53:53');
INSERT INTO `t_user_event_log` VALUES (103, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:53:56');
INSERT INTO `t_user_event_log` VALUES (104, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-07 16:57:53');
INSERT INTO `t_user_event_log` VALUES (105, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:58:25');
INSERT INTO `t_user_event_log` VALUES (106, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:59:08');
INSERT INTO `t_user_event_log` VALUES (107, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 16:59:28');
INSERT INTO `t_user_event_log` VALUES (108, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 17:00:12');
INSERT INTO `t_user_event_log` VALUES (109, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 17:01:42');
INSERT INTO `t_user_event_log` VALUES (110, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 17:03:16');
INSERT INTO `t_user_event_log` VALUES (111, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 18:11:34');
INSERT INTO `t_user_event_log` VALUES (112, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-07 18:12:27');
INSERT INTO `t_user_event_log` VALUES (113, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 18:15:30');
INSERT INTO `t_user_event_log` VALUES (114, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-07 18:20:16');
INSERT INTO `t_user_event_log` VALUES (115, 2, 'admin', '管理员', 'admin创建一个个任务为课后习题', '2022-07-07 18:32:57');
INSERT INTO `t_user_event_log` VALUES (116, 2, 'admin', '管理员', 'admin创建一个个任务为课后习题', '2022-07-07 19:01:15');
INSERT INTO `t_user_event_log` VALUES (117, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 19:01:31');
INSERT INTO `t_user_event_log` VALUES (118, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:第一次考试', '2022-07-07 19:09:59');
INSERT INTO `t_user_event_log` VALUES (119, 2, 'admin', '管理员', 'admin创建了一个时段试卷,试卷名称:假期作业', '2022-07-07 19:58:48');
INSERT INTO `t_user_event_log` VALUES (120, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-07 20:25:39');
INSERT INTO `t_user_event_log` VALUES (121, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 08:40:37');
INSERT INTO `t_user_event_log` VALUES (122, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-08 08:41:37');
INSERT INTO `t_user_event_log` VALUES (123, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 09:23:09');
INSERT INTO `t_user_event_log` VALUES (124, 1, 'student', '学生', 'student退出了考试通系统', '2022-07-08 10:38:51');
INSERT INTO `t_user_event_log` VALUES (125, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 11:20:37');
INSERT INTO `t_user_event_log` VALUES (126, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 13:59:06');
INSERT INTO `t_user_event_log` VALUES (127, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 14:38:05');
INSERT INTO `t_user_event_log` VALUES (128, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 15:27:55');
INSERT INTO `t_user_event_log` VALUES (129, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-08 15:43:47');
INSERT INTO `t_user_event_log` VALUES (130, 1, 'student', '学生', 'student退出了考试通系统', '2022-07-08 16:05:24');
INSERT INTO `t_user_event_log` VALUES (131, 7, '1902210035', NULL, '1902210035登录了考试通系统', '2022-07-08 16:30:45');
INSERT INTO `t_user_event_log` VALUES (132, 7, '1902210035', NULL, '1902210035退出了考试通系统', '2022-07-08 16:31:06');
INSERT INTO `t_user_event_log` VALUES (133, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-08 16:38:45');
INSERT INTO `t_user_event_log` VALUES (134, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-08 18:53:47');
INSERT INTO `t_user_event_log` VALUES (135, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-12 10:38:24');
INSERT INTO `t_user_event_log` VALUES (136, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-12 11:05:19');
INSERT INTO `t_user_event_log` VALUES (137, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-12 11:18:35');
INSERT INTO `t_user_event_log` VALUES (138, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-12 14:04:49');
INSERT INTO `t_user_event_log` VALUES (139, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-12 17:42:10');
INSERT INTO `t_user_event_log` VALUES (140, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-13 09:08:09');
INSERT INTO `t_user_event_log` VALUES (141, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-13 09:45:13');
INSERT INTO `t_user_event_log` VALUES (142, 2, 'admin', '管理员', 'admin创建一个个任务为暑假作业', '2022-07-13 09:45:39');
INSERT INTO `t_user_event_log` VALUES (143, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-13 14:07:07');
INSERT INTO `t_user_event_log` VALUES (144, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-13 15:59:47');
INSERT INTO `t_user_event_log` VALUES (145, 2, 'admin', '管理员', 'admin创建了一个单选题,题干:1+1=?', '2022-07-13 16:00:31');
INSERT INTO `t_user_event_log` VALUES (146, 2, 'admin', '管理员', 'admin创建了一个多选题,题干:下面算数等于1的是？', '2022-07-13 16:03:42');
INSERT INTO `t_user_event_log` VALUES (147, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:任务1', '2022-07-13 16:04:57');
INSERT INTO `t_user_event_log` VALUES (148, 2, 'admin', '管理员', 'admin创建一个个任务为国庆作业', '2022-07-13 16:05:17');
INSERT INTO `t_user_event_log` VALUES (149, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-13 16:05:27');
INSERT INTO `t_user_event_log` VALUES (150, 2, 'admin', '管理员', 'admin创建了一个多选题,题干:下面算数相加等于5的是？<br/>', '2022-07-13 16:24:31');
INSERT INTO `t_user_event_log` VALUES (151, 2, 'admin', '管理员', 'admin创建一个个任务为五一作业', '2022-07-13 17:02:59');
INSERT INTO `t_user_event_log` VALUES (152, 2, 'admin', '管理员', 'admin更新了任务1试卷', '2022-07-13 17:16:55');
INSERT INTO `t_user_event_log` VALUES (153, 2, 'admin', '管理员', 'admin更新了任务1试卷', '2022-07-13 17:20:02');
INSERT INTO `t_user_event_log` VALUES (154, 2, 'admin', '管理员', 'admin更新了任务1试卷', '2022-07-13 17:21:28');
INSERT INTO `t_user_event_log` VALUES (155, 2, 'admin', '管理员', 'admin更新了假期作业试卷', '2022-07-13 17:21:45');
INSERT INTO `t_user_event_log` VALUES (156, 2, 'admin', '管理员', 'admin更新了第一次考试试卷', '2022-07-13 17:21:54');
INSERT INTO `t_user_event_log` VALUES (157, 2, 'admin', '管理员', 'admin更新了随堂练习试卷', '2022-07-13 17:22:07');
INSERT INTO `t_user_event_log` VALUES (158, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:任务', '2022-07-13 17:46:30');
INSERT INTO `t_user_event_log` VALUES (159, 2, 'admin', '管理员', 'admin创建一个个任务为假期作业1', '2022-07-13 17:46:52');
INSERT INTO `t_user_event_log` VALUES (160, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-14 14:24:18');
INSERT INTO `t_user_event_log` VALUES (161, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-14 15:17:06');
INSERT INTO `t_user_event_log` VALUES (162, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-14 15:17:39');
INSERT INTO `t_user_event_log` VALUES (163, 2, 'admin', '管理员', 'admin创建一个个任务为国庆作业', '2022-07-14 15:18:12');
INSERT INTO `t_user_event_log` VALUES (164, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-14 16:31:27');
INSERT INTO `t_user_event_log` VALUES (165, 2, 'admin', '管理员', 'admin创建一个个任务为假期作业', '2022-07-14 16:32:12');
INSERT INTO `t_user_event_log` VALUES (166, 2, 'admin', '管理员', 'admin创建一个个任务为假期作业', '2022-07-14 16:34:15');
INSERT INTO `t_user_event_log` VALUES (167, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-14 17:45:42');
INSERT INTO `t_user_event_log` VALUES (168, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-14 19:56:48');
INSERT INTO `t_user_event_log` VALUES (169, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-14 20:25:05');
INSERT INTO `t_user_event_log` VALUES (170, 2, 'admin', '管理员', 'admin创建一个个任务为五一作业', '2022-07-14 20:25:30');
INSERT INTO `t_user_event_log` VALUES (171, 2, 'admin', '管理员', 'admin创建一个个任务为五一作业', '2022-07-14 20:31:16');
INSERT INTO `t_user_event_log` VALUES (172, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-20 08:59:36');
INSERT INTO `t_user_event_log` VALUES (173, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-20 10:06:42');
INSERT INTO `t_user_event_log` VALUES (174, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-20 10:41:06');
INSERT INTO `t_user_event_log` VALUES (175, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-20 14:02:06');
INSERT INTO `t_user_event_log` VALUES (176, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-20 14:12:32');
INSERT INTO `t_user_event_log` VALUES (177, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-20 16:22:16');
INSERT INTO `t_user_event_log` VALUES (178, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-21 15:07:28');
INSERT INTO `t_user_event_log` VALUES (179, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-21 16:55:22');
INSERT INTO `t_user_event_log` VALUES (180, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-07-21 17:25:39');
INSERT INTO `t_user_event_log` VALUES (181, 2, 'admin', '管理员', 'admin更新了任务1试卷', '2022-07-21 17:26:08');
INSERT INTO `t_user_event_log` VALUES (182, 1, 'student', '学生', 'student登录了考试通系统', '2022-07-21 17:26:28');
INSERT INTO `t_user_event_log` VALUES (183, 2, 'admin', '管理员', 'admin登录了考试通系统', '2022-08-15 19:50:08');
INSERT INTO `t_user_event_log` VALUES (184, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:二年级语文试卷1', '2022-08-20 10:50:40');
INSERT INTO `t_user_event_log` VALUES (185, 2, 'admin', '管理员', 'admin创建一个个任务为二年级任务', '2022-08-20 10:51:03');
INSERT INTO `t_user_event_log` VALUES (186, 2, 'admin', '管理员', 'admin创建了一个固定试卷,试卷名称:固定试卷二年级语文', '2022-08-20 13:17:09');
INSERT INTO `t_user_event_log` VALUES (187, 12, 'caoaxin', '曹阿鑫', 'caoaxin创建了一个时段试卷,试卷名称:一年级语文试卷', '2022-08-20 14:45:04');
INSERT INTO `t_user_event_log` VALUES (188, 1, 'student', '学生', 'student退出了考试系统', '2022-08-22 17:54:06');
INSERT INTO `t_user_event_log` VALUES (189, 1, 'student', '学生', 'student登录了考试系统', '2022-08-22 17:58:17');
INSERT INTO `t_user_event_log` VALUES (190, 1, 'student', '学生', 'student登录了考试系统', '2022-08-23 14:53:37');
INSERT INTO `t_user_event_log` VALUES (191, 6, 'teacher', '老师', 'teacher登录了考试系统', '2022-08-23 14:54:42');
INSERT INTO `t_user_event_log` VALUES (192, 6, 'teacher', '老师', 'teacher退出了考试系统', '2022-08-23 15:00:24');
INSERT INTO `t_user_event_log` VALUES (193, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-23 15:00:30');
INSERT INTO `t_user_event_log` VALUES (194, 1, 'student', '学生', 'student登录了考试系统', '2022-08-23 19:42:21');
INSERT INTO `t_user_event_log` VALUES (195, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-24 09:11:55');
INSERT INTO `t_user_event_log` VALUES (196, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-24 09:13:23');
INSERT INTO `t_user_event_log` VALUES (197, 6, 'teacher', '老师', 'teacher登录了考试系统', '2022-08-24 09:13:29');
INSERT INTO `t_user_event_log` VALUES (198, 6, 'teacher', '老师', 'teacher退出了考试系统', '2022-08-24 09:16:03');
INSERT INTO `t_user_event_log` VALUES (199, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-24 09:16:07');
INSERT INTO `t_user_event_log` VALUES (200, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-24 09:19:15');
INSERT INTO `t_user_event_log` VALUES (201, 6, 'teacher', '老师', 'teacher登录了考试系统', '2022-08-24 09:19:21');
INSERT INTO `t_user_event_log` VALUES (202, 13, 'aazaaa', NULL, 'aazaaa登录了考试系统', '2022-08-24 09:20:09');
INSERT INTO `t_user_event_log` VALUES (203, 13, 'aazaaa', NULL, 'aazaaa退出了考试系统', '2022-08-24 09:22:31');
INSERT INTO `t_user_event_log` VALUES (204, 1, 'student', '学生', 'student登录了考试系统', '2022-08-24 09:22:36');
INSERT INTO `t_user_event_log` VALUES (205, 1, 'student', '学生', 'student登录了考试系统', '2022-08-24 09:47:10');
INSERT INTO `t_user_event_log` VALUES (206, 1, 'student', '学生', 'student登录了考试系统', '2022-08-24 09:47:18');
INSERT INTO `t_user_event_log` VALUES (207, 1, 'student', '学生', 'student登录了考试系统', '2022-08-24 09:48:38');
INSERT INTO `t_user_event_log` VALUES (208, 1, 'student', '学生', 'student登录了考试系统', '2022-08-24 09:48:45');
INSERT INTO `t_user_event_log` VALUES (209, 1, 'student', '学生', 'student退出了考试系统', '2022-08-24 09:48:59');
INSERT INTO `t_user_event_log` VALUES (210, 13, 'aazaaa', NULL, 'aazaaa登录了考试系统', '2022-08-24 09:49:04');
INSERT INTO `t_user_event_log` VALUES (211, 13, 'aazaaa', NULL, 'aazaaa退出了考试系统', '2022-08-24 09:50:17');
INSERT INTO `t_user_event_log` VALUES (212, 6, 'teacher', '老师', 'teacher退出了考试系统', '2022-08-24 09:51:06');
INSERT INTO `t_user_event_log` VALUES (213, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-24 09:51:14');
INSERT INTO `t_user_event_log` VALUES (214, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-24 09:55:12');
INSERT INTO `t_user_event_log` VALUES (215, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-24 18:03:46');
INSERT INTO `t_user_event_log` VALUES (216, 2, 'admin', '管理员', 'admin更改了id为6题目', '2022-08-24 18:25:25');
INSERT INTO `t_user_event_log` VALUES (217, 2, 'admin', '管理员', 'admin更改了id为5题目', '2022-08-24 18:52:48');
INSERT INTO `t_user_event_log` VALUES (218, 2, 'admin', '管理员', 'admin创建了一个单选题,题干:下面哪个是四大名著之一？', '2022-08-24 19:23:33');
INSERT INTO `t_user_event_log` VALUES (219, 2, 'admin', '管理员', 'admin更改了id为3题目', '2022-08-24 19:26:08');
INSERT INTO `t_user_event_log` VALUES (220, 2, 'admin', '管理员', 'admin更改了id为5题目', '2022-08-24 19:26:53');
INSERT INTO `t_user_event_log` VALUES (221, 1, 'student', '学生', 'student登录了考试系统', '2022-08-24 19:48:23');
INSERT INTO `t_user_event_log` VALUES (222, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-25 15:48:18');
INSERT INTO `t_user_event_log` VALUES (223, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-25 15:52:03');
INSERT INTO `t_user_event_log` VALUES (224, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 15:52:12');
INSERT INTO `t_user_event_log` VALUES (225, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi创建了一个单选题,题干:25×35=？', '2022-08-25 15:55:36');
INSERT INTO `t_user_event_log` VALUES (226, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi创建了一个判断题,题干:25×35=875', '2022-08-25 15:56:59');
INSERT INTO `t_user_event_log` VALUES (227, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi创建了一个固定试卷,试卷名称:固定试卷1', '2022-08-25 15:58:12');
INSERT INTO `t_user_event_log` VALUES (228, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi创建了一个时段试卷,试卷名称:时段试卷1', '2022-08-25 15:59:24');
INSERT INTO `t_user_event_log` VALUES (229, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi创建了一个任务试卷,试卷名称:任务试卷1', '2022-08-25 16:00:17');
INSERT INTO `t_user_event_log` VALUES (230, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi退出了考试系统', '2022-08-25 16:00:26');
INSERT INTO `t_user_event_log` VALUES (231, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-25 16:00:31');
INSERT INTO `t_user_event_log` VALUES (232, 2, 'admin', '管理员', 'admin创建一个个任务为任务模拟1', '2022-08-25 16:00:59');
INSERT INTO `t_user_event_log` VALUES (233, 15, 'zhangStudent', NULL, 'zhangStudent登录了考试系统', '2022-08-25 16:03:02');
INSERT INTO `t_user_event_log` VALUES (234, 15, 'zhangStudent', NULL, 'zhangStudent登录了考试系统', '2022-08-25 16:16:03');
INSERT INTO `t_user_event_log` VALUES (235, 15, 'zhangStudent', NULL, 'zhangStudent登录了考试系统', '2022-08-25 16:16:12');
INSERT INTO `t_user_event_log` VALUES (236, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-25 16:20:34');
INSERT INTO `t_user_event_log` VALUES (237, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 16:20:51');
INSERT INTO `t_user_event_log` VALUES (238, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi创建了一个简答题,题干:求证1+1=2', '2022-08-25 16:23:13');
INSERT INTO `t_user_event_log` VALUES (239, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi更新了固定试卷1试卷', '2022-08-25 16:23:39');
INSERT INTO `t_user_event_log` VALUES (240, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi退出了考试系统', '2022-08-25 16:30:19');
INSERT INTO `t_user_event_log` VALUES (241, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 16:30:33');
INSERT INTO `t_user_event_log` VALUES (242, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi退出了考试系统', '2022-08-25 16:36:29');
INSERT INTO `t_user_event_log` VALUES (243, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 16:36:36');
INSERT INTO `t_user_event_log` VALUES (244, 6, 'teacher', '老师', 'teacher登录了考试系统', '2022-08-25 17:41:55');
INSERT INTO `t_user_event_log` VALUES (245, 6, 'teacher', '老师', 'teacher退出了考试系统', '2022-08-25 17:58:35');
INSERT INTO `t_user_event_log` VALUES (246, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-25 17:58:40');
INSERT INTO `t_user_event_log` VALUES (247, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-25 18:01:21');
INSERT INTO `t_user_event_log` VALUES (248, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 18:01:28');
INSERT INTO `t_user_event_log` VALUES (249, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi退出了考试系统', '2022-08-25 18:46:06');
INSERT INTO `t_user_event_log` VALUES (250, 12, 'caoaxin', '曹阿鑫', 'caoaxin登录了考试系统', '2022-08-25 18:46:31');
INSERT INTO `t_user_event_log` VALUES (251, 12, 'caoaxin', '曹阿鑫', 'caoaxin退出了考试系统', '2022-08-25 18:51:25');
INSERT INTO `t_user_event_log` VALUES (252, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 18:51:32');
INSERT INTO `t_user_event_log` VALUES (253, 15, 'zhangStudent', '曹阿鑫2', 'zhangStudent登录了考试系统', '2022-08-25 18:53:55');
INSERT INTO `t_user_event_log` VALUES (254, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 19:00:29');
INSERT INTO `t_user_event_log` VALUES (255, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi退出了考试系统', '2022-08-25 19:02:16');
INSERT INTO `t_user_event_log` VALUES (256, 12, 'caoaxin', '曹阿鑫', 'caoaxin登录了考试系统', '2022-08-25 19:02:23');
INSERT INTO `t_user_event_log` VALUES (257, 12, 'caoaxin', '曹阿鑫', 'caoaxin退出了考试系统', '2022-08-25 19:02:44');
INSERT INTO `t_user_event_log` VALUES (258, 6, 'teacher', '老师', 'teacher登录了考试系统', '2022-08-25 19:02:50');
INSERT INTO `t_user_event_log` VALUES (259, 1, 'student', '学生', 'student登录了考试系统', '2022-08-25 20:59:36');
INSERT INTO `t_user_event_log` VALUES (260, 1, 'student', '学生', 'student退出了考试系统', '2022-08-25 21:03:23');
INSERT INTO `t_user_event_log` VALUES (261, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi登录了考试系统', '2022-08-25 21:03:28');
INSERT INTO `t_user_event_log` VALUES (262, 14, 'zhanglaoshi', '曹阿鑫', 'zhanglaoshi退出了考试系统', '2022-08-25 21:03:42');
INSERT INTO `t_user_event_log` VALUES (263, 15, 'zhangStudent', '曹阿鑫2', 'zhangStudent登录了考试系统', '2022-08-25 21:04:04');
INSERT INTO `t_user_event_log` VALUES (264, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-26 09:03:36');
INSERT INTO `t_user_event_log` VALUES (265, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-26 09:15:27');
INSERT INTO `t_user_event_log` VALUES (266, 16, 'testTeacher', '曹阿鑫s', 'testTeacher登录了考试系统', '2022-08-26 09:15:46');
INSERT INTO `t_user_event_log` VALUES (267, 16, 'testTeacher', '曹阿鑫s', 'testTeacher创建了一个单选题,题干:20+80=?', '2022-08-26 09:29:20');
INSERT INTO `t_user_event_log` VALUES (268, 16, 'testTeacher', '曹阿鑫s', 'testTeacher创建了一个简答题,题干:有若干只鸡兔同在一个笼子里，从上面数，有35个头，从下面数，有94只脚。问笼中各有多少只鸡和兔？', '2022-08-26 09:31:10');
INSERT INTO `t_user_event_log` VALUES (269, 16, 'testTeacher', '曹阿鑫s', 'testTeacher创建了一个固定试卷,试卷名称:固定试卷1', '2022-08-26 09:32:05');
INSERT INTO `t_user_event_log` VALUES (270, 17, 'testStudent', NULL, 'testStudent登录了考试系统', '2022-08-26 09:38:12');
INSERT INTO `t_user_event_log` VALUES (271, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 09:56:05');
INSERT INTO `t_user_event_log` VALUES (272, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 09:56:29');
INSERT INTO `t_user_event_log` VALUES (273, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 10:16:16');
INSERT INTO `t_user_event_log` VALUES (274, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 10:18:28');
INSERT INTO `t_user_event_log` VALUES (275, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 10:18:41');
INSERT INTO `t_user_event_log` VALUES (276, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 10:18:50');
INSERT INTO `t_user_event_log` VALUES (277, 17, 'testStudent', '曹阿鑫1', 'testStudent登录了考试系统', '2022-08-26 10:20:52');
INSERT INTO `t_user_event_log` VALUES (278, 17, 'testStudent', '曹阿鑫1', 'testStudent退出了考试系统', '2022-08-26 10:24:29');
INSERT INTO `t_user_event_log` VALUES (279, 16, 'testTeacher', '曹阿鑫s', 'testTeacher退出了考试系统', '2022-08-26 10:24:59');
INSERT INTO `t_user_event_log` VALUES (280, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-26 10:47:41');
INSERT INTO `t_user_event_log` VALUES (281, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-26 10:49:15');
INSERT INTO `t_user_event_log` VALUES (282, 21, 'teacherTest', '曹阿鑫ss', 'teacherTest登录了考试系统', '2022-08-26 10:49:31');
INSERT INTO `t_user_event_log` VALUES (283, 21, 'teacherTest', '曹阿鑫ss', 'teacherTest创建了一个单选题,题干:1+2=？', '2022-08-26 10:51:19');
INSERT INTO `t_user_event_log` VALUES (284, 22, 'studentTest', NULL, 'studentTest登录了考试系统', '2022-08-26 10:52:11');
INSERT INTO `t_user_event_log` VALUES (285, 21, 'teacherTest', '曹阿鑫ss', 'teacherTest创建了一个固定试卷,试卷名称:二年级数学固定试卷1', '2022-08-26 10:54:55');
INSERT INTO `t_user_event_log` VALUES (286, 21, 'teacherTest', '曹阿鑫ss', 'teacherTest登录了考试系统', '2022-08-26 10:58:59');
INSERT INTO `t_user_event_log` VALUES (287, 21, 'teacherTest', '曹阿鑫ss', 'teacherTest创建了一个时段试卷,试卷名称:二年级八班时段试卷', '2022-08-26 11:00:05');
INSERT INTO `t_user_event_log` VALUES (288, 21, 'teacherTest', '曹阿鑫ss', 'teacherTest退出了考试系统', '2022-08-26 11:02:03');
INSERT INTO `t_user_event_log` VALUES (289, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-26 11:02:08');
INSERT INTO `t_user_event_log` VALUES (290, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:二年级任务试卷1', '2022-08-26 11:03:10');
INSERT INTO `t_user_event_log` VALUES (291, 2, 'admin', '管理员', 'admin创建了一个任务试卷,试卷名称:二年级语文任务试卷', '2022-08-26 11:03:37');
INSERT INTO `t_user_event_log` VALUES (292, 2, 'admin', '管理员', 'admin创建一个个任务为国庆作业', '2022-08-26 11:03:56');
INSERT INTO `t_user_event_log` VALUES (293, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-26 15:04:26');
INSERT INTO `t_user_event_log` VALUES (294, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-26 15:04:31');
INSERT INTO `t_user_event_log` VALUES (295, 2, 'admin', '管理员', 'admin登录了考试系统', '2022-08-26 15:05:56');
INSERT INTO `t_user_event_log` VALUES (296, 2, 'admin', '管理员', 'admin退出了考试系统', '2022-08-26 15:14:59');
INSERT INTO `t_user_event_log` VALUES (297, 16, 'testTeacher', '曹阿鑫s', 'testTeacher登录了考试系统', '2022-08-26 15:15:16');
INSERT INTO `t_user_event_log` VALUES (298, 1, 'student', '学生', 'student登录了考试系统', '2022-08-26 15:17:21');

SET FOREIGN_KEY_CHECKS = 1;
