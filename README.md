# Audio-FileReader-WAV-OGG-Code
Here’s a sample **README** file for your audio project:

---

# Audio File Metadata Extractor (WAV & OGG)

## Overview

This Java-based application is designed to read and extract metadata from **WAV** and **OGG** audio files. The tool parses the header information of these audio formats and outputs relevant details such as sample rate, number of channels, and other audio properties. It works by reading the raw binary data of the file and converting the necessary bytes into human-readable information.

## Features

- **Reads and analyzes WAV and OGG audio files**
- **Extracts metadata** from the audio file header:
  - For WAV files: Chunk ID, Chunk Size, Audio Format, Sample Rate, and more.
  - For OGG files: Version, Header Type, Granule Position, Sample Rate, and more.
- **Converts hexadecimal data** to readable format.
- **Displays path of the file** when the user inputs the filename.
  
## Requirements

- **Java 8** or higher
- **WAV** or **OGG** audio files
- The audio file must be in the **same folder as the source code** for the program to process it.

## How to Use

1. **Download** or **clone** the repository.
2. Ensure that your **WAV** or **OGG** audio file is placed in the **same folder** as the source code file.
3. **Run the program**.
4. The program will ask for the **file name** (including extension) of the audio file.
5. The program will display the **file path** and extract metadata such as sample rate, channels, and other relevant properties from the audio file header.
6. If the file format is supported (WAV or OGG), it will print the corresponding metadata.

## Example Output

For a **WAV** file:

```
File path: C:\Projects\AudioFileReader\sample.wav
the header of the file is:
ChunkID: RIFF
ChunkSize: 3000
Format: WAVE
SubChunk1ID: fmt 
SubChunk1Size: 16
AudioFormat: 1
NumChannels: 2
SampleRate: 44100
ByteRate: 88200
BlockAlign: 4
BitsPerSample: 16
SubChunk2ID: data
SubChunk2Size: 2000
```

For an **OGG** file:

```
File path: C:\Projects\AudioFileReader\sample.ogg
the header of the file is:
Capture Pattern: oggs
Version: 0
Header Type: 0
Granule Position: 5000
Bitstream Serial Number: 12345
Page Sequence Number: 1
Check Sum: 0x12345
Page Segments: 1
Audio Compression: Vorbis
Number of Channels: 2
Sample Rate: 44100
```

## Known Issues

- The program only supports **WAV** and **OGG** files. Other audio formats are not supported.
- It assumes the audio file follows the standard header structure for **WAV** and **OGG** files.
  
## Future Improvements

- Extend support for additional audio formats like MP3, FLAC, etc.
- Add functionality to extract more detailed audio properties, such as duration, bitrate, etc.
- Implement error handling for corrupted or unsupported files.

Author
Marina Abdallah– https://github.com/Marina-Abdallah
