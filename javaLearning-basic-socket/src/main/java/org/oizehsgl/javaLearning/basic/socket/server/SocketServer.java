package org.oizehsgl.javaLearning.basic.socket.server;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 套接字服务
 *
 * @author oizehsgl
 */
public class SocketServer {

  public static final String mapString =
      """
{
    "LOD+MEM": "%RLOD    MEM     00\r\nA01,'SAMPLE                           ','1688                            ',0,0,0,2,0\r\n\r\n08%",
    "LOD+PANEL": "%RLOD    PANEL   00\r\nD01,1,0,0\r\nK01,2,0,0,0,0,0,1,0,1,0,0,0,0\r\nS01,1,100,100,0,1,1,0,0,1\r\n\r\n06%",
    "LOD+VER": "%RLOD    VER     00\r\nM01,'SXd1      '\r\nV01,'DX00.03.000         ','MDX00.03.000        ','LDX00.03.000        ','HD00.03.000         ','AD00.01.001         ','                    ','                    ','                    ','                    ','                    ','                    '\r\nS01,'      132875',1,0\r\n\r\n13%",
    "LOD+PDSP":"%RLOD    PDSP    00\\r\\nL01,0\\r\\nG01,  0, 17, 22, 40, 49, 50,501,   57, 64, 67, 69, 80, 91, 94, 97, 98,  0,321\\r\\nM01,  5,  9, 97,141,221,222,223,224,230,253,269,270,290,305,400,403,405,407,409,419,431,435,441,443,445,481,483,485,487,495,322,299,474,420,340,301\\r\\nP01, -451.3700000, -255.7390000,  767.0000000,    0.0000000,  178.7170000,    0.0000000,    0.0000000,    0.0000000,           0,           0,           0,           0\\r\\nP02,  191.8120000,  -52.7390000,  259.6600000,    0.0000000,  180.0000000,    0.0000000,    0.0000000,    0.0000000,           0,           0,           0,           0\\r\\nP03,    0.5000000,  -98.3290000,  837.9720000,    0.0000000,  180.0000000,    0.0000000,    0.0000000,    0.0000000,           0,           0,           0,           0\\r\\nP04,    0.0000000,    0.0000000,    0.0000000,    0.0000000,    0.0000000,    0.0000000,    0.0000000,    0.0000000,           0,           0,           0,           0\\r\\nX01,     0.0000000,     0,0,   ,   ,  ,2,0,0,0,4,100,100, 0,0,  0\\r\\nA01,'A ','A ','B ','B ','P1','P2','P3','P4'\\r\\n03%",
    "REDPRG+20": "%RREDPRG 20      00\r\n\r\n( HN23006168-E01-0\r\n11%",
    "LOD+WKCNTR": "%RLOD    WKCNTR  00\r\nA01,  1,     3,  9999,     0\r\nA02,  0,     0,     0,     0\r\nA03,  0,     0,     0,     0\r\nA04,  0,     0,     0,     0\r\nB01,  0,     0,     0,     0\r\nB02,  0,     0,     0,     0\r\nB03,  0,     0,     0,     0\r\nB04,  0,     0,     0,     0\r\n\r\n14%",
    "LOD+ALARM": "%RLOD    ALARM   00\r\nE01,0200080000000000000003,020008000000000000000A,0200160000000000000003,020016000000000000000A,900500                ,907516                ,9075110000000000000018,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      ,                      \r\nL01,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           ,           \r\n\r\n03%",
    "REDPRGN": "%RREDPRGN        00\r\n16881688             1\r\n07%",
    "LOD+TOLNDD": "%RLOD    TOLNDD  00\r\nT001,554.310,0.000,0.000,0.000,4,10000,10,6686,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT002,539.630,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT003,538.340,0.000,-0.030,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT004,527.070,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT005,583.190,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT006,546.790,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT007,523.890,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT008,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT009,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT010,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT011,511.340,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT012,508.479,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT013,526.040,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT014,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT015,524.640,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT016,528.190,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT017,524.430,-0.100,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT018,541.770,0.750,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT019,512.920,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT020,534.220,0.800,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT021,526.970,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT022,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT023,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT024,0.000,0.000,-0.050,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT025,0.000,0.000,-0.030,0.000,,0,0,0,'              ',,,,,,1,1,,0.000,0.000,0.000,0.000,\r\nT026,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT027,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT028,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT029,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT030,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT031,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT032,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT033,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT034,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT035,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT036,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT037,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT038,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT039,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT040,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT041,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT042,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT043,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT044,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT045,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT046,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT047,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT048,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT049,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT050,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT051,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT052,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT053,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT054,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT055,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT056,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT057,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT058,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT059,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT060,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT061,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT062,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT063,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT064,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT065,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT066,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT067,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT068,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT069,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT070,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT071,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT072,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT073,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT074,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT075,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT076,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT077,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT078,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT079,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT080,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT081,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT082,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT083,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT084,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT085,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT086,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT087,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT088,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT089,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT090,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT091,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT092,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT093,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT094,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT095,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT096,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT097,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT098,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT099,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT201,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT202,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT203,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT204,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT205,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT206,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT207,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT208,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT209,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT210,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT211,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT212,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT213,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT214,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT215,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT216,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT217,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT218,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT219,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT220,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT221,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT222,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT223,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT224,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT225,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT226,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT227,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT228,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT229,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT230,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT231,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT232,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT233,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT234,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT235,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT236,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT237,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT238,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT239,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT240,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT241,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT242,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT243,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT244,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT245,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT246,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT247,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT248,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT249,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT250,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT251,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT252,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT253,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT254,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT255,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT256,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT257,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT258,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT259,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT260,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT261,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT262,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT263,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT264,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT265,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT266,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT267,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT268,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT269,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT270,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT271,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT272,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT273,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT274,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT275,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT276,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT277,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT278,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT279,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT280,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT281,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT282,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT283,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT284,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT285,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT286,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT287,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT288,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT289,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT290,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT291,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT292,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT293,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT294,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT295,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT296,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT297,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT298,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nT299,0.000,0.000,0.000,0.000,,0,0,0,'              ',,,,,,0,0,,0.000,0.000,0.000,0.000,\r\nV001,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV002,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV003,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV004,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV005,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV006,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV007,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV008,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV009,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV010,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV011,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV012,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV013,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV014,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV015,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV016,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV017,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV018,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV019,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV020,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV021,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV022,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV023,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV024,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV025,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV026,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV027,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV028,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV029,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nV030,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\nM001,,,,,,,,,,,,,,,,\r\nM002,,,,,,,,,,,,,,,,\r\nM003,,,,,,,,,,,,,,,,\r\nM004,,,,,,,,,,,,,,,,\r\nM005,,,,,,,,,,,,,,,,\r\nM006,,,,,,,,,,,,,,,,\r\nM007,,,,,,,,,,,,,,,,\r\nM008,,,,,,,,,,,,,,,,\r\nM009,,,,,,,,,,,,,,,,\r\nM010,,,,,,,,,,,,,,,,\r\nM011,,,,,,,,,,,,,,,,\r\nM012,,,,,,,,,,,,,,,,\r\nM013,,,,,,,,,,,,,,,,\r\nM014,,,,,,,,,,,,,,,,\r\nM015,,,,,,,,,,,,,,,,\r\nM016,,,,,,,,,,,,,,,,\r\nM017,,,,,,,,,,,,,,,,\r\nM018,,,,,,,,,,,,,,,,\r\nM019,,,,,,,,,,,,,,,,\r\nM020,,,,,,,,,,,,,,,,\r\nM021,,,,,,,,,,,,,,,,\r\nM022,,,,,,,,,,,,,,,,\r\nM023,,,,,,,,,,,,,,,,\r\nM024,,,,,,,,,,,,,,,,\r\nM025,,,,,,,,,,,,,,,,\r\nM026,,,,,,,,,,,,,,,,\r\nM027,,,,,,,,,,,,,,,,\r\nM028,,,,,,,,,,,,,,,,\r\nM029,,,,,,,,,,,,,,,,\r\nM030,,,,,,,,,,,,,,,,\r\nM031,,,,,,,,,,,,,,,,\r\nM032,,,,,,,,,,,,,,,,\r\nM033,,,,,,,,,,,,,,,,\r\nM034,,,,,,,,,,,,,,,,\r\nM035,,,,,,,,,,,,,,,,\r\nM036,,,,,,,,,,,,,,,,\r\nM037,,,,,,,,,,,,,,,,\r\nM038,,,,,,,,,,,,,,,,\r\nM039,,,,,,,,,,,,,,,,\r\nM040,,,,,,,,,,,,,,,,\r\nM041,,,,,,,,,,,,,,,,\r\nM042,,,,,,,,,,,,,,,,\r\nM043,,,,,,,,,,,,,,,,\r\nM044,,,,,,,,,,,,,,,,\r\nM045,,,,,,,,,,,,,,,,\r\nM046,,,,,,,,,,,,,,,,\r\nM047,,,,,,,,,,,,,,,,\r\nM048,,,,,,,,,,,,,,,,\r\nM049,,,,,,,,,,,,,,,,\r\nM050,,,,,,,,,,,,,,,,\r\nM051,,,,,,,,,,,,,,,,\r\nM052,,,,,,,,,,,,,,,,\r\nM053,,,,,,,,,,,,,,,,\r\nM054,,,,,,,,,,,,,,,,\r\nM055,,,,,,,,,,,,,,,,\r\nM056,,,,,,,,,,,,,,,,\r\nM057,,,,,,,,,,,,,,,,\r\nM058,,,,,,,,,,,,,,,,\r\nM059,,,,,,,,,,,,,,,,\r\nM060,,,,,,,,,,,,,,,,\r\nM061,,,,,,,,,,,,,,,,\r\nM062,,,,,,,,,,,,,,,,\r\nM063,,,,,,,,,,,,,,,,\r\nM064,,,,,,,,,,,,,,,,\r\nM065,,,,,,,,,,,,,,,,\r\nM066,,,,,,,,,,,,,,,,\r\nM067,,,,,,,,,,,,,,,,\r\nM068,,,,,,,,,,,,,,,,\r\nM069,,,,,,,,,,,,,,,,\r\nM070,,,,,,,,,,,,,,,,\r\nM071,,,,,,,,,,,,,,,,\r\nM072,,,,,,,,,,,,,,,,\r\nM073,,,,,,,,,,,,,,,,\r\nM074,,,,,,,,,,,,,,,,\r\nM075,,,,,,,,,,,,,,,,\r\nM076,,,,,,,,,,,,,,,,\r\nM077,,,,,,,,,,,,,,,,\r\nM078,,,,,,,,,,,,,,,,\r\nM079,,,,,,,,,,,,,,,,\r\nM080,,,,,,,,,,,,,,,,\r\nM081,,,,,,,,,,,,,,,,\r\nM082,,,,,,,,,,,,,,,,\r\nM083,,,,,,,,,,,,,,,,\r\nM084,,,,,,,,,,,,,,,,\r\nM085,,,,,,,,,,,,,,,,\r\nM086,,,,,,,,,,,,,,,,\r\nM087,,,,,,,,,,,,,,,,\r\nM088,,,,,,,,,,,,,,,,\r\nM089,,,,,,,,,,,,,,,,\r\nM090,,,,,,,,,,,,,,,,\r\nM091,,,,,,,,,,,,,,,,\r\nM092,,,,,,,,,,,,,,,,\r\nM093,,,,,,,,,,,,,,,,\r\nM094,,,,,,,,,,,,,,,,\r\nM095,,,,,,,,,,,,,,,,\r\nM096,,,,,,,,,,,,,,,,\r\nM097,,,,,,,,,,,,,,,,\r\nM098,,,,,,,,,,,,,,,,\r\nM099,,,,,,,,,,,,,,,,\r\nM201,,,,,,,,,,,,,,,,\r\nM202,,,,,,,,,,,,,,,,\r\nM203,,,,,,,,,,,,,,,,\r\nM204,,,,,,,,,,,,,,,,\r\nM205,,,,,,,,,,,,,,,,\r\nM206,,,,,,,,,,,,,,,,\r\nM207,,,,,,,,,,,,,,,,\r\nM208,,,,,,,,,,,,,,,,\r\nM209,,,,,,,,,,,,,,,,\r\nM210,,,,,,,,,,,,,,,,\r\nM211,,,,,,,,,,,,,,,,\r\nM212,,,,,,,,,,,,,,,,\r\nM213,,,,,,,,,,,,,,,,\r\nM214,,,,,,,,,,,,,,,,\r\nM215,,,,,,,,,,,,,,,,\r\nM216,,,,,,,,,,,,,,,,\r\nM217,,,,,,,,,,,,,,,,\r\nM218,,,,,,,,,,,,,,,,\r\nM219,,,,,,,,,,,,,,,,\r\nM220,,,,,,,,,,,,,,,,\r\nM221,,,,,,,,,,,,,,,,\r\nM222,,,,,,,,,,,,,,,,\r\nM223,,,,,,,,,,,,,,,,\r\nM224,,,,,,,,,,,,,,,,\r\nM225,,,,,,,,,,,,,,,,\r\nM226,,,,,,,,,,,,,,,,\r\nM227,,,,,,,,,,,,,,,,\r\nM228,,,,,,,,,,,,,,,,\r\nM229,,,,,,,,,,,,,,,,\r\nM230,,,,,,,,,,,,,,,,\r\nM231,,,,,,,,,,,,,,,,\r\nM232,,,,,,,,,,,,,,,,\r\nM233,,,,,,,,,,,,,,,,\r\nM234,,,,,,,,,,,,,,,,\r\nM235,,,,,,,,,,,,,,,,\r\nM236,,,,,,,,,,,,,,,,\r\nM237,,,,,,,,,,,,,,,,\r\nM238,,,,,,,,,,,,,,,,\r\nM239,,,,,,,,,,,,,,,,\r\nM240,,,,,,,,,,,,,,,,\r\nM241,,,,,,,,,,,,,,,,\r\nM242,,,,,,,,,,,,,,,,\r\nM243,,,,,,,,,,,,,,,,\r\nM244,,,,,,,,,,,,,,,,\r\nM245,,,,,,,,,,,,,,,,\r\nM246,,,,,,,,,,,,,,,,\r\nM247,,,,,,,,,,,,,,,,\r\nM248,,,,,,,,,,,,,,,,\r\nM249,,,,,,,,,,,,,,,,\r\nM250,,,,,,,,,,,,,,,,\r\nM251,,,,,,,,,,,,,,,,\r\nM252,,,,,,,,,,,,,,,,\r\nM253,,,,,,,,,,,,,,,,\r\nM254,,,,,,,,,,,,,,,,\r\nM255,,,,,,,,,,,,,,,,\r\nM256,,,,,,,,,,,,,,,,\r\nM257,,,,,,,,,,,,,,,,\r\nM258,,,,,,,,,,,,,,,,\r\nM259,,,,,,,,,,,,,,,,\r\nM260,,,,,,,,,,,,,,,,\r\nM261,,,,,,,,,,,,,,,,\r\nM262,,,,,,,,,,,,,,,,\r\nM263,,,,,,,,,,,,,,,,\r\nM264,,,,,,,,,,,,,,,,\r\nM265,,,,,,,,,,,,,,,,\r\nM266,,,,,,,,,,,,,,,,\r\nM267,,,,,,,,,,,,,,,,\r\nM268,,,,,,,,,,,,,,,,\r\nM269,,,,,,,,,,,,,,,,\r\nM270,,,,,,,,,,,,,,,,\r\nM271,,,,,,,,,,,,,,,,\r\nM272,,,,,,,,,,,,,,,,\r\nM273,,,,,,,,,,,,,,,,\r\nM274,,,,,,,,,,,,,,,,\r\nM275,,,,,,,,,,,,,,,,\r\nM276,,,,,,,,,,,,,,,,\r\nM277,,,,,,,,,,,,,,,,\r\nM278,,,,,,,,,,,,,,,,\r\nM279,,,,,,,,,,,,,,,,\r\nM280,,,,,,,,,,,,,,,,\r\nM281,,,,,,,,,,,,,,,,\r\nM282,,,,,,,,,,,,,,,,\r\nM283,,,,,,,,,,,,,,,,\r\nM284,,,,,,,,,,,,,,,,\r\nM285,,,,,,,,,,,,,,,,\r\nM286,,,,,,,,,,,,,,,,\r\nM287,,,,,,,,,,,,,,,,\r\nM288,,,,,,,,,,,,,,,,\r\nM289,,,,,,,,,,,,,,,,\r\nM290,,,,,,,,,,,,,,,,\r\nM291,,,,,,,,,,,,,,,,\r\nM292,,,,,,,,,,,,,,,,\r\nM293,,,,,,,,,,,,,,,,\r\nM294,,,,,,,,,,,,,,,,\r\nM295,,,,,,,,,,,,,,,,\r\nM296,,,,,,,,,,,,,,,,\r\nM297,,,,,,,,,,,,,,,,\r\nM298,,,,,,,,,,,,,,,,\r\nM299,,,,,,,,,,,,,,,,\r\n\r\n12%",
    "LOD+MCRNDD": "%RLOD    MCRNDD  00\r\nC500,\r\nC501,\r\nC502,\r\nC503,\r\nC504,\r\nC505,\r\nC506,\r\nC507,\r\nC508,\r\nC509,\r\nC510,231025.000\r\nC511,1.000\r\nC512,\r\nC513,\r\nC514,\r\nC515,\r\nC516,\r\nC517,\r\nC518,\r\nC519,\r\nC520,\r\nC521,\r\nC522,\r\nC523,\r\nC524,\r\nC525,\r\nC526,\r\nC527,\r\nC528,\r\nC529,\r\nC530,2.000\r\nC531,10054.000\r\nC532,4.000\r\nC533,5.000\r\nC534,0.000\r\nC535,0.000\r\nC536,1.000\r\nC537,0.000\r\nC538,\r\nC539,\r\nC540,3349.000\r\nC541,0.000\r\nC542,3.000\r\nC543,3.000\r\nC544,4.000\r\nC545,8.000\r\nC546,\r\nC547,\r\nC548,\r\nC549,\r\nC550,\r\nC551,\r\nC552,\r\nC553,\r\nC554,\r\nC555,\r\nC556,\r\nC557,\r\nC558,\r\nC559,\r\nC560,\r\nC561,\r\nC562,\r\nC563,\r\nC564,\r\nC565,\r\nC566,\r\nC567,\r\nC568,\r\nC569,\r\nC570,\r\nC571,\r\nC572,\r\nC573,\r\nC574,\r\nC575,\r\nC576,\r\nC577,\r\nC578,\r\nC579,\r\nC580,\r\nC581,\r\nC582,\r\nC583,\r\nC584,\r\nC585,\r\nC586,\r\nC587,\r\nC588,\r\nC589,\r\nC590,\r\nC591,\r\nC592,\r\nC593,\r\nC594,\r\nC595,\r\nC596,\r\nC597,\r\nC598,\r\nC599,\r\nC600,\r\nC601,\r\nC602,\r\nC603,\r\nC604,\r\nC605,\r\nC606,\r\nC607,\r\nC608,\r\nC609,\r\nC610,\r\nC611,\r\nC612,\r\nC613,\r\nC614,\r\nC615,\r\nC616,\r\nC617,\r\nC618,\r\nC619,\r\nC620,\r\nC621,\r\nC622,\r\nC623,\r\nC624,\r\nC625,\r\nC626,\r\nC627,\r\nC628,\r\nC629,\r\nC630,\r\nC631,\r\nC632,\r\nC633,\r\nC634,\r\nC635,\r\nC636,\r\nC637,\r\nC638,\r\nC639,\r\nC640,\r\nC641,\r\nC642,\r\nC643,\r\nC644,\r\nC645,\r\nC646,\r\nC647,\r\nC648,\r\nC649,\r\nC650,\r\nC651,\r\nC652,\r\nC653,\r\nC654,\r\nC655,\r\nC656,\r\nC657,\r\nC658,\r\nC659,\r\nC660,\r\nC661,\r\nC662,\r\nC663,\r\nC664,\r\nC665,\r\nC666,\r\nC667,\r\nC668,\r\nC669,\r\nC670,\r\nC671,\r\nC672,\r\nC673,\r\nC674,\r\nC675,\r\nC676,\r\nC677,\r\nC678,\r\nC679,\r\nC680,\r\nC681,\r\nC682,\r\nC683,\r\nC684,\r\nC685,\r\nC686,\r\nC687,\r\nC688,\r\nC689,\r\nC690,\r\nC691,\r\nC692,\r\nC693,\r\nC694,\r\nC695,\r\nC696,\r\nC697,\r\nC698,\r\nC699,\r\nC700,\r\nC701,\r\nC702,\r\nC703,\r\nC704,\r\nC705,\r\nC706,\r\nC707,\r\nC708,\r\nC709,\r\nC710,\r\nC711,\r\nC712,\r\nC713,\r\nC714,\r\nC715,\r\nC716,\r\nC717,\r\nC718,\r\nC719,\r\nC720,\r\nC721,\r\nC722,\r\nC723,\r\nC724,\r\nC725,\r\nC726,\r\nC727,\r\nC728,\r\nC729,\r\nC730,\r\nC731,\r\nC732,\r\nC733,\r\nC734,\r\nC735,\r\nC736,\r\nC737,\r\nC738,\r\nC739,\r\nC740,\r\nC741,\r\nC742,\r\nC743,\r\nC744,\r\nC745,\r\nC746,\r\nC747,\r\nC748,\r\nC749,\r\nC750,\r\nC751,\r\nC752,\r\nC753,\r\nC754,\r\nC755,\r\nC756,\r\nC757,\r\nC758,\r\nC759,\r\nC760,\r\nC761,\r\nC762,\r\nC763,\r\nC764,\r\nC765,\r\nC766,\r\nC767,\r\nC768,\r\nC769,\r\nC770,\r\nC771,\r\nC772,\r\nC773,\r\nC774,\r\nC775,\r\nC776,\r\nC777,\r\nC778,\r\nC779,\r\nC780,\r\nC781,\r\nC782,\r\nC783,\r\nC784,\r\nC785,\r\nC786,\r\nC787,\r\nC788,\r\nC789,\r\nC790,\r\nC791,\r\nC792,\r\nC793,\r\nC794,\r\nC795,\r\nC796,\r\nC797,\r\nC798,\r\nC799,\r\nC800,\r\nC801,\r\nC802,\r\nC803,\r\nC804,\r\nC805,\r\nC806,\r\nC807,\r\nC808,\r\nC809,\r\nC810,\r\nC811,\r\nC812,\r\nC813,\r\nC814,\r\nC815,\r\nC816,\r\nC817,\r\nC818,\r\nC819,\r\nC820,\r\nC821,\r\nC822,\r\nC823,\r\nC824,\r\nC825,\r\nC826,\r\nC827,\r\nC828,\r\nC829,\r\nC830,\r\nC831,\r\nC832,\r\nC833,\r\nC834,\r\nC835,\r\nC836,\r\nC837,\r\nC838,\r\nC839,\r\nC840,\r\nC841,\r\nC842,\r\nC843,\r\nC844,\r\nC845,\r\nC846,\r\nC847,\r\nC848,\r\nC849,\r\nC850,\r\nC851,\r\nC852,\r\nC853,\r\nC854,\r\nC855,\r\nC856,\r\nC857,\r\nC858,\r\nC859,\r\nC860,\r\nC861,\r\nC862,\r\nC863,\r\nC864,\r\nC865,\r\nC866,\r\nC867,\r\nC868,\r\nC869,\r\nC870,\r\nC871,\r\nC872,\r\nC873,\r\nC874,\r\nC875,\r\nC876,\r\nC877,\r\nC878,\r\nC879,\r\nC880,\r\nC881,\r\nC882,\r\nC883,\r\nC884,\r\nC885,\r\nC886,\r\nC887,\r\nC888,\r\nC889,\r\nC890,\r\nC891,\r\nC892,\r\nC893,\r\nC894,\r\nC895,\r\nC896,\r\nC897,\r\nC898,\r\nC899,\r\nC900,\r\nC901,\r\nC902,\r\nC903,\r\nC904,\r\nC905,\r\nC906,\r\nC907,\r\nC908,\r\nC909,\r\nC910,\r\nC911,\r\nC912,\r\nC913,\r\nC914,\r\nC915,\r\nC916,\r\nC917,\r\nC918,\r\nC919,\r\nC920,\r\nC921,\r\nC922,\r\nC923,\r\nC924,\r\nC925,\r\nC926,\r\nC927,\r\nC928,\r\nC929,\r\nC930,\r\nC931,\r\nC932,\r\nC933,\r\nC934,\r\nC935,\r\nC936,\r\nC937,\r\nC938,\r\nC939,\r\nC940,\r\nC941,\r\nC942,\r\nC943,\r\nC944,\r\nC945,\r\nC946,\r\nC947,\r\nC948,\r\nC949,\r\nC950,\r\nC951,\r\nC952,\r\nC953,\r\nC954,\r\nC955,\r\nC956,\r\nC957,\r\nC958,\r\nC959,\r\nC960,\r\nC961,\r\nC962,\r\nC963,\r\nC964,\r\nC965,\r\nC966,\r\nC967,\r\nC968,\r\nC969,\r\nC970,\r\nC971,\r\nC972,\r\nC973,\r\nC974,\r\nC975,\r\nC976,\r\nC977,\r\nC978,\r\nC979,\r\nC980,\r\nC981,\r\nC982,\r\nC983,\r\nC984,\r\nC985,\r\nC986,\r\nC987,\r\nC988,\r\nC989,\r\nC990,\r\nC991,\r\nC992,\r\nC993,\r\nC994,\r\nC995,\r\nC996,\r\nC997,\r\nC998,\r\nC999,\r\n\r\n14%"
}
        """;
  public static Map<String, String> map;

  /**
   * @param string 发送的指令
   * @return {@link String} 提取后格式化的指令,当作存储在map中的key
   * @throws Exception 提取指令异常
   */
  public static String extractCmdFromSend(String string) throws Exception {
    // 先从%向后两个字符开始,截取到\r字符结束
    int percentIndex = string.indexOf('%');
    int returnIndex = string.indexOf('\r');
    String firstLineString = string.substring(percentIndex + 2, returnIndex);
    // 删除末尾空格并把连续空格替换为一个+
    return firstLineString.trim().replaceAll("\\s+", "+");
  }

  public static void main(String[] args) {
    Gson gson = new Gson();
    Type type = new com.google.gson.reflect.TypeToken<Map<String, String>>() {}.getType();
    map = gson.fromJson(mapString, type);

    new Thread(() -> new SocketServer().server(10000)).start();
    new Thread(() -> new SocketServer().server(10001)).start();
    new Thread(() -> new SocketServer().server(10002)).start();
    try {
      Thread.sleep(1000 * 60 * 60);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void server(int port) {
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(port);
    } catch (Exception e) {
      System.err.println("socket初始化服务错误" + e.getMessage());
    }
    while (true) {
      Socket socket = null;
      OutputStream outputStream = null;
      InputStream inputStream = null;
      try {
        socket = serverSocket.accept();
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
      } catch (Exception e) {
        System.err.println("socket初始化连接错误" + e.getMessage());
      }
      Map<String, String> realMap = new HashMap<>();

      while (true) {
        try {
          Thread.sleep(10);
          // 接收数据
          byte[] buffer = new byte[1024 * 64];
          System.out.println("read开始");
          int length = inputStream.read(buffer);
          System.out.println("read结束");
          String request = new String(buffer, 0, length);
          System.out.println("Client request: " + request);
          // 发送数据
          System.out.println("write开始");

          String key = extractCmdFromSend(request);
          String value = Optional.ofNullable(map.get(key)).orElse("%ICCCFFFFSSSSSSSS00\r\n00%");
          System.out.println(key + "---------" + value);
          realMap.put(request, value);
          outputStream.write((value).getBytes());

          System.out.println("write结束");
          System.out.println("flush开始");
          outputStream.flush();
          System.out.println("flush开始");
        } catch (Exception e) {
          System.err.println("socket通讯错误" + e.getMessage());
          break;
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println(new Gson().toJson(realMap));
        System.out.println("--------------------------------------------------------------------");
      }
      // 关闭连接
      try {
        socket.close();
        // serverSocket.close();
      } catch (Exception e) {
        System.err.println("socket关闭错误" + e.getMessage());
      }
    }
  }

  public void client() throws IOException {
    Socket socket = new Socket("127.0.0.1", 10001);
    OutputStream outputStream = socket.getOutputStream();
    InputStream inputStream = socket.getInputStream();
    // 发送数据
    outputStream.write("Hello Server".getBytes());
    // 接收数据
    byte[] buffer = new byte[1024];
    int length = inputStream.read(buffer);
    String response = new String(buffer, 0, length);
    System.out.println("Server response: " + response);
    // 关闭连接
    socket.close();
  }
}
