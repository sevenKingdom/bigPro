package com.carry.common.creatlogfile;

/**
 * Created by songxianying on 17/8/29.
 */
public class HtmlModel {
    public static String start = "<html>\n" +
            "\n" +
            "<head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, maximum-scale=1.0, user-scalable=0\">\n" +
            "  <title>日志</title>\n" +
            "  <style>\n" +
            "    .form-page {\n" +
            "      width: 750px;\n" +
            "      margin: 0 auto;\n" +
            "    }\n" +
            "    table {\n" +
            "      width: 100%;\n" +
            "      border-collapse:collapse;\n" +
            "      border-spacing:0;\n" +
            "      border-right:1px solid #aaa;\n" +
            "      border-bottom:1px solid #aaa;\n" +
            "    }\n" +
            "    table td {\n" +
            "      padding: 0;\n" +
            "      border-left:1px solid #aaa;\n" +
            "      border-top:1px solid #aaa;\n" +
            "    }\n" +
            "    .red {\n" +
            "      color: red;\n" +
            "    }\n" +
            "  </style>\n" +
            "</head>";
    public static String head = "<body>\n" +
            "<div class=\"form-page\">\n" +
            "<p align=\"center\" ><font size=\"6\"><b>安全检查日志</b></font> </p>\n" +
            "<p align=\"center\">{0}</p>\n" +
            "<p align=\"right\"><tr><td>天气：{1}</td><td>日期：{2}</td></p>\n" ;
    public static String planname1 = "<p align=\"left\"><b>施工日计划：</b></p>\n";
    public static String planname2 = "<p align=\"left\"><b>复检计划：</b></p>\n";
    public static String plan =
            "<table>\n" +
            "      <tr>\n" +
            "        <td></td>\n" +
            "        <td align=\"center\">墩号</td>\n" +
            "        <td align=\"center\">结构</td>\n" +
            "        <td align=\"center\">工序</td>\n" +
            "        <td align=\"center\">是否需论证</td>\n" +
            "        <td align=\"center\">是否已论证</td>\n" +
            "      </tr>\n" +
            "      {0}\n" +
            "    </table>";

    public static String plantd = "<tr>\n" +
            "        <td align=\"center\">{0}</td>\n" +
            "        <td align=\"center\">{1}</td>\n" +
            "        <td align=\"center\">{2}</td>\n" +
            "        <td align=\"center\">{3}</td>\n" +
            "        <td align=\"center\">{4}</td>\n" +
            "        <td align=\"center\">{5}</td>\n" +
            "      </tr>";
    public static String itemname1 = "<p align=\"left\">计划检查：</p>\n";
    public static String itemname2 = "<p align=\"left\">复检计划检查：</p>\n";
    public static String item =
            "<p align=\"center\"><font size=\"5\"><b>{0}</b></font></p>\n" +
            "<p align=\"center\"><tr>\n" +
            "        <td>检查员：{1}</td>\n" +
            "        <td>负责工班长：{2}</td>\n" +
            "        \n" +
            "      </tr></p>\n" +
            "\n" +
            "<p align=\"left\"><tr>\n" +
            "        <td></td>\n" +
            "        <td><b>合格项：</b></td>    \n" +
            "      </tr></p>\n" +
            "\n" +
            "<table>\n" +
            "      <tr>\n" +
            "        <td width=\"100\" align=\"center\">检查项</td>\n" +
            "        <td width=\"100\" align=\"center\">安全级别</td>\n" +
            "        <td align=\"center\">图片</td>\n" +
            "      </tr>\n" +
            "      {3}\n" +
            "    </table>\n" +
            "<p align=\"left\"><tr>\n" +
            "        <td></td>\n" +
            "\n" +
            "        <td><b><div class=\"red\">不合格项：</div></b></td>    \n" +
            "      </tr></p>\n" +
            "\n" +
            "<table>\n" +
            "      <tr>\n" +
            "        <td width=\"100\" align=\"center\">检查项</td>\n" +
            "        <td width=\"100\" align=\"center\">安全级别</td>\n" +
            "        <td align=\"center\">图片</td>\n" +
            "      </tr>\n" +
            "      {4}\n" +
            "    </table>\n" +
            "\n" +
            "        </p>\n" +
            "\n";
    public static String fenge = "<br />\n" +
            "<br />\n" +
            "<hr />\n" +
            "<hr />\n" +
            "<hr />\n" +
            "<br />\n" +
            "<br />";
    public static String itemtd = "<tr>\n" +
            "        <td width=\"100\" align=\"center\">{0}</td>\n" +
            "        <td width=\"100\" align=\"center\">{1}</td>\n" +
            "        <td align=\"center\"><img src=\"{2}\"  alt=\"检查图片\" /></td>\n" +
            "      </tr>\n" ;
    public static String end = "</body>\n" +
            "\n" +
            "</html>";
}
