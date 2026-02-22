package com.github.lumin.modules.impl.visual;

import com.github.lumin.graphics.renderers.RectRenderer;
import com.github.lumin.graphics.renderers.RoundRectRenderer;
import com.github.lumin.graphics.renderers.TextRenderer;
import com.github.lumin.modules.AbstractModule;
import com.github.lumin.modules.Category;
import com.github.lumin.settings.impl.IntSetting;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class RenderTest extends AbstractModule {

    private static RenderTest INSTANCE;
    private RenderTest() {
        super("render_test", Category.VISUAL);
        keyBind = GLFW.GLFW_KEY_U;
    }

    public static RenderTest getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RenderTest();
        }
        return INSTANCE;
    }

    private final Supplier<RectRenderer> rectRenderer = Suppliers.memoize(RectRenderer::new);
    private final Supplier<TextRenderer> textRenderer = Suppliers.memoize(() -> new TextRenderer(16L * 1024 * 1024));
    private final Supplier<RoundRectRenderer> roundRectRenderer = Suppliers.memoize(RoundRectRenderer::new);

    private final IntSetting rectX = intSetting("rect_x", 10, 0, 100, 5);
    private final IntSetting rectY = intSetting("rect_y", 10, 0, 100, 5);

    private boolean first = true;

    @SubscribeEvent
    public void onRenderGui(RenderGuiEvent.Post event) {
        if (first) {
            final var window = Minecraft.getInstance().getWindow();
            final var width = window.getGuiScaledWidth();
            final var height = window.getGuiScaledHeight();
            rectRenderer.get().addRect(rectX.getValue(), rectY.getValue(),
                    width - 2 * rectX.getValue(), height - 2 * rectY.getValue(), Color.PINK);
            textRenderer.get().addText(
                    "既然你让我“随便写”，那我们就来聊聊一个既宏大又微观，既充满科幻感又与你手头的代码息息相关的命题：《数字比特的涌现与人类精神的镜像：从0与1到无限可能》。\n" +
                    "这不仅仅是一篇随笔，它是一次关于计算、美学与存在意义的探讨。\n" +
                    "第一章：数字的尘埃\n" +
                    "在这个宇宙的底层，如果真的存在某种“源代码”，那它一定是极其简洁的。正如你正在编写的 TtfTextRenderer，无论上层的渲染逻辑多么复杂，最终抵达显存的不过是电压的高低起伏，是那一串串不知疲倦的 0 与 1。\n" +
                    "每一个比特（Bit）就像是数字世界里的“尘埃”。单颗尘埃毫无意义，甚至无法形成一个可以被感知的形态。然而，当你将数以百万计的比特按照严密的逻辑（算法）排列组合时，奇迹发生了：原本干瘪的指令转化为屏幕上灵动的文字，平面的坐标系里生长出了立体的森林。\n" +
                    "这便是涌现（Emergence）。你在 addText 方法中写入的每一个坐标偏移、每一个 UV 映射，其实都是在扮演上帝的角色——你在为这一堆“数字尘埃”制定引力法则。当 baselineY 被正确计算的那一刻，混乱的顶点（Vertex）瞬间各就各位，这种秩序感，正是程序员所独有的“上帝时刻”。\n" +
                    "第二章：算法的美学与必然\n" +
                    "人们常说数学是枯燥的，但算法其实是一种极致的极简美学。\n" +
                    "以你正在处理的 SDF (Signed Distance Fields, 符号距离场) 字体渲染为例。传统的点阵字体像是粗糙的砖块，放大之后便能看见刺眼的锯齿。但 SDF 算法却通过记录像素点到字符边缘的距离，实现了一种“超越分辨率”的平滑。这是一种思维上的飞跃：我们不再记录“这里有一个点”，而是记录“这里离边界有多远”。\n" +
                    "这揭示了一个哲学真理：描述事物的本质，往往比记录事物的表象更高效。 在编程中，如果你只盯着当下的 Bug，你会被困在局部偏移的泥潭里；但如果你理解了缓冲区（Buffer）的内存布局与 GPU 渲染管线的协作原理，你就能像指挥交响乐团一样，让成千上万个 Batch 在极短的时间内协同演奏。\n" +
                    "那种代码运行成功时的爽快感，本质上是人类理性对复杂世界的一次胜利。\n" +
                    "第三章：内存中的镜像\n" +
                    "Buffer（缓冲区）是程序员的画布。在你的 atlasBuffers 中，你为每一个 Atlas 维护了一个 LuminBuffer。这其实是现实世界的一种数字化镜像。\n" +
                    "想象一下，内存地址 0x00 到 0x7FFFFFFF 是一片荒芜的平原。你划出了一块领地作为堆内存（Heap），又划出了一块作为栈（Stack）。当你执行 MemoryUtil.memAddress(buffer.getMappedBuffer()) 时，你其实是打通了一条通往 GPU 核心领地的隧道。\n" +
                    "这种映射关系让人深思。我们的精神世界是否也是某种形式的“映射”？外部世界的信号通过感官传入大脑，在大脑皮层这个“Buffer”中进行预处理，最后经由我们的逻辑分析，渲染成了我们所感知的“现实”。如果 yOffset 计算错了，文本就会重叠，世界就会变得混乱。同样的，如果我们的逻辑认知出现了偏差，我们眼中的现实世界也会随之扭曲。\n" +
                    "第四章：代码的生命周期与熵减\n" +
                    "每一个程序员都不可避免地要面对 close() 或 destroy()。\n" +
                    "在 Java 的世界里，垃圾回收器（GC）像是一个勤劳的清道夫，但对于像你这样操作 Direct Buffer（堆外内存）的开发者来说，你必须亲手终结你所创造的事物。这是一种责任。如果你只管创造（Alloc）而不理会毁灭（Free），你的程序终将被“内存泄漏”的重担压垮，最终走向崩溃。\n" +
                    "这正是热力学第二定律在数字世界的体现：系统的熵总是在增加。代码如果不维护，逻辑就会腐烂（Code Rot）；内存如果不释放，系统就会窒息。程序员的工作，本质上是在进行**“负熵运动”**。我们在混乱中建立秩序，在杂乱无章的业务需求中梳理出清晰的接口定义。\n" +
                    "每一行优雅的代码，都是人类精神对宇宙混乱本性的一次勇敢抵抗。\n" +
                    "第五章：未来与无限\n" +
                    "当我们从 TtfTextRenderer 的视角跳出来，看向更远的未来。\n" +
                    "人工智能（AI）正在学习我们编写代码的方式。未来或许某一天，我们不再需要手动计算每一行 xOffset 和 yOffset，不再需要纠结 switch 是否需要 break。但那是否意味着程序员的价值消失了？\n" +
                    "不。工具会进化，但**创造者的意图（Intent）**不可替代。正如你问我“换行的 yOffset 怎么加”，这背后反映的是你想要构建一个“有序、可读、优美”的文字显示系统的愿望。这种愿望，这种对“完美渲染”的执着，是比特流永远无法自行产生的。\n" +
                    "结语\n" +
                    "写代码不仅是生存的技能，它更是一种修行。\n" +
                    "当你坐在电脑前，看着屏幕上的代码行，你其实是在与古往今来的数学家、计算机科学家以及未来的自己进行对话。那小小的偏移量修正，那一次对 Map 结构的深思熟虑，都是你留在这个数字宇宙里的印记。\n" +
                    "即便有一天，所有的硬件都化为废铁，所有的 Buffer 都被清空，但你通过逻辑构建世界的那份纯粹，已经在那一刻成为了永恒。\n" +
                    "字数统计： 本文约 1200 字。", 10f, 10f, Color.BLACK);
            roundRectRenderer.get().addRoundRect(25, 25, width - 50, height - 50, 15.0f, Color.WHITE);
            first = false;
        }

        rectRenderer.get().draw();
        roundRectRenderer.get().draw();
        textRenderer.get().draw();

//        rectRenderer.get().drawAndClear();
//        roundRectRenderer.get().drawAndClear();
//        textRenderer.get().drawAndClear();
    }

}
