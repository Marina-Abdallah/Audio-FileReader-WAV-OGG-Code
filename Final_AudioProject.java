package final_audioproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

//this program can read .WAV file & .OGG 
public class Final_AudioProject {

    public static byte[] reverse(byte x[]) {

        int n = x.length;
        byte[] y = new byte[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            y[j - 1] = x[i];
            j = j - 1;
        }
        return y;
    }

    public static String hexToString(byte[] output) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder buf = new StringBuilder();
        for (int j = 0; j < output.length; j++) {
            buf.append(hexDigit[(output[j] >> 4) & 0x0f]);
            buf.append(hexDigit[output[j] & 0x0f]);
        }

        return buf.toString();

    }

    public static void RunWAV(byte[] array) {
        System.out.println("the header of the file is : ");

        String ChunkID = new String(Arrays.copyOfRange(array, 0, 4));
        System.out.println("ChunkID :  " + ChunkID);

        String ChunkSize = hexToString(reverse(Arrays.copyOfRange(array, 4, 8)));
        int i_ChunkSize = Integer.parseInt(ChunkSize, 16);
        System.out.println("ChunkSize :  " + i_ChunkSize);

        String Format = new String(Arrays.copyOfRange(array, 8, 12));
        System.out.println("Format :  " + Format);

        String SubChunk1ID = new String(Arrays.copyOfRange(array, 12, 16));
        System.out.println("SubChunk1ID :  " + SubChunk1ID);

        String SubChunk1Size = hexToString(reverse(Arrays.copyOfRange(array, 16, 20)));
        int i_SubChunk1Size = Integer.parseInt(SubChunk1Size, 16);
        System.out.println("SubChunk1Size :  " + i_SubChunk1Size);

        String AudioFormat = hexToString(reverse(Arrays.copyOfRange(array, 20, 22)));
        int i_AudioFormat = Integer.parseInt(AudioFormat, 16);
        System.out.println("AudioFormat :  " + i_AudioFormat);

        String NumChannels = hexToString(reverse(Arrays.copyOfRange(array, 22, 24)));
        int i_NumChannels = Integer.parseInt(NumChannels, 16);
        System.out.println("NumChannels :  " + i_NumChannels);

        String SampleRate = hexToString(reverse(Arrays.copyOfRange(array, 24, 28)));
        int i_SampleRate = Integer.parseInt(SampleRate, 16);
        System.out.println("SampleRate :  " + i_SampleRate);

        String ByteRate = hexToString(reverse(Arrays.copyOfRange(array, 28, 32)));
        int i_ByteRate = Integer.parseInt(ByteRate, 16);
        System.out.println("ByteRate :  " + i_ByteRate);

        String BlockAlign = hexToString(reverse(Arrays.copyOfRange(array, 32, 34)));
        int i_BlockAlign = Integer.parseInt(BlockAlign, 16);
        System.out.println("BlockAlign :  " + i_BlockAlign);

        String BitsPerSample = hexToString(reverse(Arrays.copyOfRange(array, 34, 36)));
        int i_BitsPerSample = Integer.parseInt(BitsPerSample, 16);
        System.out.println("BitsPerSample :  " + i_BitsPerSample);

        String SubChunk2ID = new String(Arrays.copyOfRange(array, 36, 40));
        System.out.println("SubChunk2ID :  " + SubChunk2ID);

        String SubChunk2Size = hexToString(reverse(Arrays.copyOfRange(array, 40, 44)));
        int i_SubChunk2Size = Integer.parseInt(SubChunk2Size, 16);
        System.out.println("SubChunk2Size :  " + i_SubChunk2Size);

    }

    public static void RunOGG(byte[] array) {
        System.out.println("the header of the file is : ");

        String CapturePattern = new String(Arrays.copyOfRange(array, 0, 4));
        System.out.println("Capture Pattern : " + CapturePattern);

        String Version = hexToString(Arrays.copyOfRange(array, 4, 5));
        int i_Version = Integer.parseInt(Version, 16);
        System.out.println("Version : " + i_Version);

        String HeaderType = hexToString(Arrays.copyOfRange(array, 5, 6));
        int i_HeaderType = Integer.parseInt(HeaderType, 16);
        System.out.println("Header Type : " + i_HeaderType);

        String GranulePosition = hexToString(reverse(Arrays.copyOfRange(array, 6, 14)));
        int i_GranulePosition = Integer.parseInt(GranulePosition, 2);
        System.out.println("Granule Position : " + i_GranulePosition);

        String BitstreamSerialNumber = hexToString(reverse(Arrays.copyOfRange(array, 14, 18)));
        int i_BitstreamSerialNumber = Integer.parseInt(BitstreamSerialNumber, 16);
        System.out.println("Bitstream Serial Number : " + i_BitstreamSerialNumber);

        String PageSequenceNumber = hexToString(reverse(Arrays.copyOfRange(array, 18, 22)));
        int i_PageSequenceNumber = Integer.parseInt(PageSequenceNumber, 16);
        System.out.println("Page Sequence Number : " + i_PageSequenceNumber);

        String CheckSum = hexToString(reverse(Arrays.copyOfRange(array, 22, 26)));
        int i_CheckSum = Integer.parseInt(CheckSum, 16);
        System.out.println("Check Sum : " + i_CheckSum);

        String PageSegments = hexToString(reverse(Arrays.copyOfRange(array, 26, 27)));
        int i_PageSegments = Integer.parseInt(PageSegments, 16);
        System.out.println("Page Segments : " + i_PageSegments);

        String AudioCompression = new String(Arrays.copyOfRange(array, 29, 35));
        System.out.println("Audio Compression : " + AudioCompression);

        String NumberOfChannels = hexToString(Arrays.copyOfRange(array, 38, 40));
        int i_NumberOfChannels = Integer.parseInt(NumberOfChannels, 16);
        System.out.println("Number Of Channels : " + i_NumberOfChannels);

        String SampleRate = hexToString(reverse(Arrays.copyOfRange(array, 40, 44)));
        int i_SampleRate = Integer.parseInt(SampleRate, 16);
        System.out.println("Sample Rate : " + i_SampleRate);

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the file name with extension and make sure that file on same folder of project");
        System.out.print("File Name: ");
        String in = sc.next();

        //return the path to user
        Path RelativePath = Paths.get(in);
        Path AbsolutePath = RelativePath.toAbsolutePath();
        System.out.println("File path: " + AbsolutePath);

        byte[] array = new byte[45];
        InputStream input = new FileInputStream(in);
        // Read byte from the file and store in array
        input.read(array);

        //check if this file is WAVE or OGG
        String test = new String(Arrays.copyOfRange(array, 0, 4));
        if (test.equalsIgnoreCase("Riff")) {
            RunWAV(array);
        } else if (test.equalsIgnoreCase("oggs")) {
            RunOGG(array);
        } else {
            System.out.println("this program doesn't support this type of files");
        }
    }

}
