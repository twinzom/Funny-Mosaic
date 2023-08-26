# FunnyMosaic

FunnyMosaic is a Java application that applies a mosaic filter to an input image.

## How to Run

To run the application, you need to have Java installed on your machine. 

Then, navigate to the directory containing the `Run.java` file in your terminal and compile the Java file using the command:

```
javac Run.java
```

To run the compiled Java file, use the command:

```
java Run <IMAGE_PATH> <LEN_SIZE>
```

Replace `<IMAGE_PATH>` with the path to the image you want to apply the mosaic filter to and `<LEN_SIZE>` with the desired length size.

For example:

```
java Run /path/to/input.jpg 5
```

## Sample Output

**Input image**

<img src="https://github.com/twinzom/Funny-Mosaic/blob/master/input.jpg?raw=true" width="300" >

**Hex mosaic**

<img src="https://github.com/twinzom/Funny-Mosaic/blob/master/input.jpg.hex.mosaic.png?raw=true" width="300" >

**input.jpg**

<img src="https://github.com/twinzom/Funny-Mosaic/blob/master/input.jpg.tri.mosaic.png?raw=true" width="300" >

## To-Do

1. **Image Formats:** The program currently only supports PNG format for the output image. It could be improved to support multiple output formats.

2. **Performance:** The performance of the mosaic filter could potentially be improved. This could be achieved by optimizing the TriangleMosaicFilter and HexgaonMosaicFilter classes or by implementing multithreading.

## License

MIT License

Copyright (c) 2023 Twinzom

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
