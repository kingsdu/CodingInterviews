package OfferDemo;

public class IPTest {
    public boolean isInnerIP(String ipAddress){/*判断是否是内网IP*/
        boolean isInnerIp = false;//默认给定IP不是内网IP
        long ipNum = getIpNum(ipAddress);
        /**
         * 私有IP：A类  10.0.0.0    -10.255.255.255
         *       B类  172.16.0.0  -172.31.255.255
         *       C类  192.168.0.0 -192.168.255.255
         *       D类   127.0.0.0   -127.255.255.255(环回地址)
         **/
        long aBegin = getIpNum("10.0.0.0");
        long aEnd = getIpNum("10.255.255.255");
        long bBegin = getIpNum("172.16.0.0");
        long bEnd = getIpNum("172.31.255.255");
        long cBegin = getIpNum("192.168.0.0");
        long cEnd = getIpNum("192.168.255.255");
        long dBegin = getIpNum("127.0.0.0");
        long dEnd = getIpNum("127.255.255.255");
        isInnerIp = isInner(ipNum,aBegin,aEnd) || isInner(ipNum,bBegin,bEnd) || isInner(ipNum,cBegin,cEnd) || isInner(ipNum,dBegin,dEnd);
        return isInnerIp;
    }

    private long getIpNum(String ipAddress) {/*获取IP数*/
        String [] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);
        long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }

    private boolean isInner(long userIp,long begin,long end){
        return (userIp>=begin) && (userIp<=end);
    }

    public static void main(String[] args) {
        if (new IPTest().isInnerIP("22.8.129.60")) {//172.16.0.119
            System.out.println("该IP地址为内网IP！");
        } else {
            System.out.println("该IP地址为外网IP！");
        }
    }
}
