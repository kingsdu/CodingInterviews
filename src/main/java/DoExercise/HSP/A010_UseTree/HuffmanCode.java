package DoExercise.HSP.A010_UseTree;

import java.io.*;
import java.util.*;

/**
 * 哈夫曼编码：
 * 1、统计每个编码出现的次数
 * 2、根据次数构建哈夫曼树
 * 3、识别需要编码的语句
 * 4、从根节点起，遍历树结构，找其中的字符，并记录遍历的路径码，形成压缩码
 * 5、解压
 */
public class HuffmanCode
{
    public static void main(String[] args)
    {
//        String srcFile1 = "d://Uninstall.xml";
//        String dstFile1 = "d://Uninstall.zip";
//
//        zipFile(srcFile1, dstFile1);
//        System.out.println("压缩文件ok~~");
//
//        String zipFile = "d://Uninstall.zip";
//        String dstFile = "d://Uninstall2.xml";
//        unZipFile(zipFile, dstFile);
//        System.out.println("解压成功!");
        
        
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        
        
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes) + " 长度= " + huffmanCodesBytes.length);
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        
        System.out.println("原来的字符串=" + new String(sourceBytes));
        
//        List<TreeNode> nodes = getNodes(contentBytes);
//        System.out.println("nodes=" + nodes);
//
//        //测试一把，创建的赫夫曼树
//        System.out.println("赫夫曼树");
//        TreeNode huffmanTreeRoot = createHuffmanTree(nodes);
//        System.out.println("前序遍历");
//        huffmanTreeRoot.preOrder();
//
//        //测试一把是否生成了对应的赫夫曼编码
//        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//        System.out.println("~生成的赫夫曼编码表= " + huffmanCodes);
//
//        //测试
//        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//        System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));//17
    }
    
    /**
     * 编写方法，将一个文件进行压缩
     *
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(String srcFile, String dstFile)
    {
        OutputStream os = null;
        ObjectOutputStream oos = null;
        FileInputStream is = null;
        try
        {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[] huffmanBytes = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            try
            {
                is.close();
                oos.close();
                os.close();
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * 哈夫曼编码主方法
     *
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes)
    {
        List<TreeNode> nodes = getNodes(bytes);
        TreeNode huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
    
    
    /**
     * @param bytes        这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 举例： String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返回的是 字符串 "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes  ，即 8位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] =  10101000(补码) => byte  [推导  10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes)
        {
            stringBuilder.append(huffmanCodes.get(b));
        }
        
        int len;
        if (stringBuilder.length() % 8 == 0)
        {
            len = stringBuilder.length() / 8;
        } else
        {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8)
        {
            String strByte;
            if (i + 8 > stringBuilder.length())
            {
                strByte = stringBuilder.substring(i);
            } else
            {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
    
    
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();
    
    
    private static Map<Byte, String> getCodes(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    
    
    private static void getCodes(TreeNode TreeNode, String code, StringBuilder stringBuilder)
    {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (TreeNode != null)
        {
            if (TreeNode.data == null)//非叶子节点
            {
                getCodes(TreeNode.left, "0", stringBuilder2);
                getCodes(TreeNode.right, "1", stringBuilder2);
            } else//叶子节点
            {
                huffmanCodes.put(TreeNode.data, stringBuilder2.toString());
            }
        }
    }
    
    private static TreeNode createHuffmanTree(List<TreeNode> nodes)
    {
        while (nodes.size() > 1)
        {
            Collections.sort(nodes);
            TreeNode leftNode = nodes.get(0);
            TreeNode rightNode = nodes.get(1);
            TreeNode parent = new TreeNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    
    
    /**
     * 统计二进制字符出现的次数
     *
     * @param bytes
     * @return
     */
    private static List<TreeNode> getNodes(byte[] bytes)
    {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes)
        {
            Integer count = counts.get(b);
            if (count == null)
            {
                counts.put(b, 1);
            } else
            {
                counts.put(b, count + 1);
            }
        }
        
        for (Map.Entry<Byte, Integer> entry : counts.entrySet())
        {
            nodes.add(new TreeNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
    
    
    public static void unZipFile(String zipFile, String dstFile)
    {
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try
        {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            
            try
            {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e2)
            {
                System.out.println(e2.getMessage());
            }
            
        }
    }
    
    
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++)
        {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet())
        {
            map.put(entry.getValue(), entry.getKey());
        }
        
        List<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length(); )
        {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;
            
            while (flag)
            {
                String key = stringBuilder.substring(i, i + count);//循环匹配，先后找map中是否存在字符，存在就拿出来，否则就继续匹配
                b = map.get(key);
                if (b == null)
                {
                    count++;
                } else
                {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = list.get(i);
        }
        return b;
    }
    
    /**
     * 将一个byte 转成一个二进制的字符串, 如果看不懂，可以参考我讲的Java基础 二进制的原码，反码，补码
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b)
    {
        int temp = b;
        if (flag)
        {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag)
        {
            return str.substring(str.length() - 8);
        } else
        {
            return str;
        }
    }
    
    static class TreeNode implements Comparable<TreeNode>
    {
        Byte data;
        int weight;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(Byte data, int weight)
        {
            this.data = data;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(TreeNode o)
        {
            return this.weight - o.weight;
        }
        
        //前序遍历
        public void preOrder()
        {
            System.out.println(this);
            if (this.left != null)
            {
                this.left.preOrder();
            }
            if (this.right != null)
            {
                this.right.preOrder();
            }
        }
    }
    
    
}
