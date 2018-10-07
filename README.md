# wii-parental-unlocker
Disable Nintendo Wii parental code if you forgot password

## Usage

### Command Line (CLI)

`java -jar npu-cli.jar [<platform> [<confirmationNumber> [<monthDay>]]]`

Example Command: `java -jar npu-cli.jar Wii 12345678 10-02`

### GUI Java Application

- Open the `npu.jar` file.
or
- `javaw npu.jar`

## Development Set-Up

  - Install Lombok for your IDE
    - `java -jar ~/.m2/repository/org/projectlombok/lombok/1.18.2/lombok-1.18.2.jar`
    - For Mac users: I could not select the Eclipse 2018-09 application,
      - so I manually copied the `lombok.jar` file into the `.../Eclipse.app/Contents/MacOS/` directory,
      - and added `-javaagent:lombok.jar` to the `.../Eclipse.app/Contents/Eclipse/eclipse.ini` file.
      - https://nawaman.net/blog/2017-11-05