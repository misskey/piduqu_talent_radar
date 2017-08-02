package com.piduqu.radar.common.utils;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * Project: xyc
 * Create by:      刘锐
 * Phone:  18782973813
 * Email：rui.liu@hirebigdata.cn
 * Date：     2015/12/23
 * Description：
 * <p/>
 * Function：
 * 1.
 */
public class ImageUtil {
    private static final Logger log = Logger.getLogger(ImageUtil.class);
    private static int width = 95;
    private static int height = 40;

    public ImageUtil(int width, int height) {
        this.width = width > 0 ? width : this.width;
        this.height = height > 0 ? height : this.height;
    }

    /**
     * 获取随机验图形验证码
     *
     * @param randomString 验证码
     * @return
     */
    public static BufferedImage createImage(String randomString) {
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 设定字体
//        g.setFont(new Font("楷体", Font.BOLD, 20));
        // 设定背景色
        g.setColor(getRandColor(220, 250));
        g.fillRect(0, 0, width, height);
        Random random = new Random();
        // 随机产生80条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 80; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        char[] rondomChars = randomString.toCharArray();
        for (int i = 0; i < rondomChars.length; i++) {
            // 设定字体
            g.setFont(new Font("楷体", random.nextInt(2), random.nextInt(8) + 28));
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            /* 从字符数组i的位置开始绘制1个字符 */
            int offsetX = random.nextInt(8) - random.nextInt(8);
            int offsetY = random.nextInt(8) - random.nextInt(8);
            g.drawChars(rondomChars, i, 1, 18 * i + 12 + offsetX, 32 + offsetY);
        }
        // 图象生效
        g.dispose();
        return image;
    }

    /**
     * 随机颜色
     *
     * @param fc
     * @param bc
     * @return
     */
    public static Color getRandColor(int fc, int bc) {
        // 给定范围获得随机颜色
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 随机数字
     *
     * @param length 数字长度
     * @return
     */
    public static String getRandomString(int length) {
        // 实例化一个Random对象
        Random random = new Random();
        String sRand = "";
        int itmp = 0;
        for (int i = 0; i < length; i++) {
            // 生成0~9的数字
            itmp = random.nextInt(10) + 48;
            char ctmp = (char) itmp;
            sRand += String.valueOf(ctmp);
        }
        return sRand;
    }

    public static InputStream cut(InputStream is, int width,
                                  int height, Rectangle rect, String suffix) throws IOException {
        Image image = ImageIO.read(is);
        BufferedImage bf = makeThumbnail(image, width, height, suffix);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        saveSubImage(bf, rect, os, suffix);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(os.toByteArray());
        os.close();
        return inputStream;
    }

    /**
     * 绘制缩放图
     *
     * @param img    原图
     * @param width  目标图宽
     * @param height 目标图高
     * @param suffix 后缀名
     * @return
     */
    private static BufferedImage makeThumbnail(Image img, int width, int height, String suffix) {
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g;
        if (!"png".equals(suffix)) {
            g = tag.createGraphics();
        } else {
            g = tag.createGraphics();
            // 解决图片背景透明问题
            tag = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
            g.dispose();
            g = tag.createGraphics();
        }
        g.drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH),
                0, 0, null);
        g.dispose();
        return tag;
    }

    /**
     * 裁剪图片
     *
     * @param image          原图
     * @param subImageBounds 裁剪矩形框
     * @throws java.io.IOException
     */
    private static void saveSubImage(BufferedImage image, Rectangle subImageBounds, OutputStream os, String suffix) throws IOException {

        BufferedImage subImage = new BufferedImage(subImageBounds.width, subImageBounds.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g;
        if (!"png".equals(suffix)) {
            g = subImage.createGraphics();
        } else {
            g = subImage.createGraphics();
            // 解决图片背景透明问题
            subImage = g.getDeviceConfiguration().createCompatibleImage(subImageBounds.width, subImageBounds.height, Transparency.TRANSLUCENT);
            g.dispose();
            g = subImage.createGraphics();
        }

        if (subImageBounds.width > image.getWidth()
                || subImageBounds.height > image.getHeight()) {
            int left = subImageBounds.x;
            int top = subImageBounds.y;
            if (image.getWidth() < subImageBounds.width)
                left = (int) ((subImageBounds.width - image.getWidth()) / 2);
            if (image.getHeight() < subImageBounds.height)
                top = (int) ((subImageBounds.height - image.getHeight()) / 2);
            g.setColor(Color.white);
            g.fillRect(0, 0, subImageBounds.width, subImageBounds.height);

            g.drawImage(image, left, top, null);
            //g.drawImage(image, left, top, width, height, null);

            ImageIO.write(image, suffix, os);
            //System.out.println("if is running left:" + left + " top: " + top);
        } else {
            // BufferedImage subImage =
            // image.getSubimage(subImageBounds.x,subImageBounds.y,
            // subImageBounds.width, subImageBounds.height);

            g.drawImage(image.getSubimage(subImageBounds.x, subImageBounds.y,
                    subImageBounds.width, subImageBounds.height), 0, 0, null);
            //System.out.println("else is running");
        }
        g.dispose();
        ImageIO.write(subImage, suffix, os);
    }
}
