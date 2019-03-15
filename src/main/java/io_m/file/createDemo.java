package io_m.file;

import java.io.File;
import java.util.Arrays;

public class createDemo {
    public static void main(String[] args) {
        String string="&到底 是什么 让人 成为 物质 主义 者 呢？ 这种 对 财富 的 热爱 来源于 人们 的 性格、 孩提 时 或 成年 后的 经历 吗？ 根据 心理学 家 兰· 纽 伦· 卓 别 林 与 黛 博 拉· 罗 德· 约翰 的 研究， 物质 主义 远在 我们 小时候 就 已在 脑海 里 扎根 了， 这 主要 是 受到 不 自信 的 驱动。 也就是说， 物质 主义 者 由于 缺乏 自信， 需要 通过 对 物质 的 占有 来 增强 自信心。 这个 研究 分为 两部分， 研究人员 首先 让 一组 年龄 在 8 岁 到 18 岁 的 人 完成 一次 标准 的 自尊心 测试（ 其中 的 一些 评估 问题 包括“ 对 自己的 相貌 是否 满意” 等）。 接着， 研究人员 将 一块 画着 许多 图案 的 显示 板 递给 了 这些 孩子， 显示 板 上 的 图案 涉及 五个 一般性 话题： 兴趣（ 比如“ 露营”“ 滑板”）、 体育运动（ 比如“ 足球”“ 网球”）、 物品（ 比如“ 新 鞋子”“ 个人 电脑”）、 人物（ 比如“ 朋友”“ 老师”）， 以及 成就（ 比如“ 获得 好的 分数”“ 学会 弹奏 一种 乐器”）。 研究人员 要求 孩子们 看着 显示 板， 围绕“ 如何 让我 变得 更快 乐” 的 主题， 运用 其中 任意 一个 图案 去 创造 一幅 拼贴 画。 这一 充满 乐趣 的 任务 让 研究人员 能够 通过 每个 孩子 选择“ 物品” 的 比例， 去 评估 他们 在 物质 层 面上 的 偏好。 研究 显示， 自信 与 物质 主义 之间 存在\n" +
                "\n" +
                " & 着 密切 的 关系， 那些 自信 度 较低 的 孩子 要比 他们的 朋友 拥有 更 强的 物品 占有 欲。 这种 因果关系 有可能 是 倒转 过 来的 吗？ 会不会 是 物质 主义 导致 缺乏 自信 呢？ 为了 测验 这种 可能性， 一组 孩子 被 要求 在 一张 纸板 上 写下 自己的 优点， 然后 研究人员 读出 每个 孩子 赞美 自己的 话。 这种 简单 的“ 写出 自身 优点” 的 做法 大大 增强 了 孩子 的 自信心。 更为 重要的 是， 这 让 孩子们 将 之前“ 如何 让我 变得 更快 乐” 的 拼 贴画 里 的“ 物品” 减去 了 一半。 这个 实验 再次 证明 较低 的 自信 度 会 造成 物质 主义 的 倾向， 而这 种 倾向 会在 年幼 时 形成。 不过 实验 也 向我 们 证明了， 就 像 只需 花 一 点钱 在 别人 身上 或是 做 一些 小小 的 善举 就能 变得 快乐 一样， 一张 纸板 和 片刻 的 时间 也能 改变 人们 的 思考 和 行为 方式。\n";
        string.replace("&","\n");
        string=string.replace(" ","");
        System.out.println(string);


        File file=new File("testFile/childDir");
        boolean res=file.mkdirs();
        System.out.println("create result is "+res);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());

        System.out.println(Arrays.asList(new String[]{"1","2"}));

        volumeUpDown("/rre","/rre","-10");
    }

    static String[] volumeUpDown(String srcfile,String dstFile,String delate){
        String cmd="ffmpeg -i "+srcfile+" -af volume="+delate+"dB"+" "+dstFile;
        String[] cmds=cmd.split(" ");
        System.out.println(Arrays.asList(cmds));
        return cmds;
    }
}

