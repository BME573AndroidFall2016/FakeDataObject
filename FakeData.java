package com.example.simplegraph.livegraph;

import com.jjoe64.graphview.series.DataPoint;

import java.util.Arrays;

import static android.R.attr.left;

/**
 * Created by Dave on 11/7/2016.
 */

public class FakeData {
    private int sampleHz;
    private int packetSize;
    private int[] fakeECG;
    private int currentIndex = 0;
    private int currentTime = 0;
    private DataPoint[] currentBuffer = new DataPoint[packetSize];

    public FakeData(int in_sampleHz, int in_packetSize){
        sampleHz = in_sampleHz;
        packetSize = in_packetSize;
        int[] in_fakeECG = new int[]{1035,
                1035,
                1041,
                1041,
                1041,
                1046,
                1057,
                1068,
                1078,
                1084,
                1089,
                1089,
                1089,
                1094,
                1105,
                1116,
                1126,
                1143,
                1164,
                1175,
                1180,
                1180,
                1196,
                1223,
                1250,
                1266,
                1287,
                1309,
                1335,
                1357,
                1378,
                1410,
                1448,
                1475,
                1485,
                1512,
                1533,
                1555,
                1582,
                1608,
                1630,
                1646,
                1646,
                1651,
                1651,
                1646,
                1619,
                1582,
                1555,
                1528,
                1496,
                1453,
                1410,
                1384,
                1362,
                1325,
                1287,
                1266,
                1234,
                1218,
                1201,
                1169,
                1148,
                1132,
                1126,
                1126,
                1121,
                1121,
                1116,
                1116,
                1116,
                1116,
                1110,
                1110,
                1105,
                1094,
                1094,
                1094,
                1100,
                1105,
                1105,
                1110,
                1110,
                1100,
                1100,
                1105,
                1105,
                1105,
                1105,
                1105,
                1094,
                1089,
                1089,
                1089,
                1078,
                1078,
                1073,
                1073,
                1073,
                1068,
                1062,
                1057,
                1057,
                1046,
                1052,
                1057,
                1057,
                1052,
                1046,
                1046,
                1035,
                1035,
                1041,
                1041,
                1035,
                1035,
                1035,
                1041,
                1041,
                1041,
                1041,
                1041,
                1035,
                1035,
                1030,
                1030,
                1035,
                1035,
                1035,
                1030,
                1030,
                1030,
                1030,
                1030,
                1030,
                1035,
                1035,
                1030,
                1035,
                1035,
                1025,
                1025,
                1025,
                1025,
                1035,
                1035,
                1035,
                1035,
                1035,
                1030,
                1030,
                1035,
                1041,
                1041,
                1041,
                1041,
                1041,
                1041,
                1035,
                1035,
                1041,
                1052,
                1078,
                1089,
                1089,
                1089,
                1084,
                1105,
                1132,
                1169,
                1185,
                1185,
                1185,
                1185,
                1180,
                1175,
                1148,
                1110,
                1084,
                1068,
                1062,
                1057,
                1035,
                1035,
                1025,
                1030,
                1030,
                1025,
                1025,
                1014,
                1014,
                1014,
                1019,
                1014,
                1003,
                998,
                1003,
                1003,
                998,
                993,
                918,
                880,
                902,
                1110,
                1496,
                1999,
                2583,
                3129,
                3531,
                3595,
                3161,
                2272,
                1303,
                666,
                500,
                570,
                666,
                682,
                661,
                612,
                607,
                607,
                607,
                623,
                612,
                629,
                682,
                757,
                827,
                880,
                918,
                944,
                982,
                998,
                1014,
                1019,
                1025,
                1030,
                1025,
                1030,
                1035};
        fakeECG = in_fakeECG;

    }
    public void bufferUpdater(){
        DataPoint[] newBuffer = new DataPoint[packetSize];
        int counter = 0;
        for (int i = currentIndex; i < currentIndex + packetSize; i++) {
            if (i > fakeECG.length-1) {
                int leftOver = currentIndex + packetSize - i;
                for (int j = 0; j < leftOver; j++) {
                    DataPoint temp = new DataPoint(currentTime, fakeECG[j]);
                    newBuffer[counter] = temp;
                    counter++;
                    currentTime++;
                }
                break;
            }

            DataPoint temp = new DataPoint(i, fakeECG[i]);
            newBuffer[counter] = temp;
            counter++;
            currentTime++;
        }
        currentIndex = currentIndex + packetSize;
        if (currentIndex > fakeECG.length) {
            currentIndex = currentIndex - fakeECG.length;
        }
        currentBuffer = newBuffer;
    }

    public DataPoint[] getData() {
        this.bufferUpdater();
        return currentBuffer;
    }

}



