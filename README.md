Spinal Project Template
=======================

This repository is a SBT project to help starting your SpinalHDL works. SpinalHDL officially provides a [SBT template](https://github.com/SpinalHDL/SpinalTemplateSbt), and this repository is inspired by [Chisel](https://github.com/freechipsproject/chisel-template) and introduces some GitHub Actions to get you started a clean project.

You can choose this template or the [official one](https://github.com/SpinalHDL/SpinalTemplateSbt) at will.

## Dependencies

### JDK

Before starting, please make sure you have a JDK >= 8 installed. You can install a JDK through the package manager that comes with your OS, or just download a prebuilt binaries such as [AdoptOpenJDK](https://adoptopenjdk.net/).

To install a JDK LTS:

```sh
# macOS with Homebrew
brew install openjdk@11
# Ubuntu
apt install default-jdk
```

### SBT

SBT is a build tool widely used by Scala projects. If you only compile your Scala code in Intellij IDEA, you can use its built-in SBT without installing another one. Otherwise, you need download it from its [official website](https://www.scala-sbt.org/download.html) so that you can use SBT on the command line.

### Verilator (optional)

If you want to run the Scala-written testbench, you need to install a simulation tool, such as Verilator.

To install a Verilator:
```sh
# macOS with Homebrew
brew install verilator
# Ubuntu
apt install verilator
```

Sometimes the Verilator version installed with the package manager is too old, and you need to compile it manually. [Here](https://verilator.org/guide/latest/install.html) are the steps to compile it from scratch.

To veiw the vcd files generated in simulation, a waveform view tool is also required. You can use GTKWave or other commercial tools.

### Intellij IDEA (optional)

Intellij IDEA is a IDE widely used in the Scala community. We strongly recommend you to used it, if you need an IDE.

Intellij IDEA is developed by JetBrains, and you can download it from [here](https://www.jetbrains.com/idea/)(the free Community Edition is good enough). You also need to install its Scala plugin (when you run Intellij IDEA the first time, it will ask you about it).

## Get started

#### Create a repository from the template

This repository is a Github template. You can create your own repository from it by clicking the green `Use this template` in the top right.
Please leave `Include all branches` **unchecked**; checking it will pollute the history of your new repository.
For more information, see ["Creating a repository from a template"](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/creating-a-repository-from-a-template).

**Do NOT clone this repository directly to the local.**

#### Wait for the template cleanup workflow to complete

After using the template to create your own blank project, please wait a minute or two for the `Template cleanup` workflow to run which will removes some template-specific stuff from the repository (like the LICENSE).
Refresh the repository page in your browser until you see a 2nd commit by `actions-user` titled `Template cleanup`.

#### Clone your repository

Once you have created a repository from this template and the `Template cleanup` workflow has completed, you can click the green `Code` to get a link for cloning your repository.

```sh
git clone git@github.com:%REPOSITORY%.git
cd %NAME%
```
(The variables wrapped in `%` will be filled in by the template cleanup) <!-- #REMOVE-ON-CLEANUP# -->

#### Try the example code

Now you have a working SpinalHDL project. Some example RTL code written in Scala, which implements a simple counter, can be found in `src/main/scala/mylib/MyTopLevel.scala`.
And `src/main/scala/mylib/MyTopLevelSim.scala` is its corresponding testbench.

Open a terminal in the root of your cloned repository and run `sbt run`. The first time it runs, the process may take some minutes to download dependencies.

```sh
//If you want to generate the Verilog of your design
sbt "runMain mylib.MyTopLevelVerilog"

//If you want to generate the VHDL of your design
sbt "runMain mylib.MyTopLevelVhdl"

//If you want to run the scala written testbench
sbt "runMain mylib.MyTopLevelSim"
```

#### Dive into SpinalHDL and have fun!

It's time to create your own hardware! And you will discover the charm of Spinal.

Don't forget:
- Set project organization and name in `build.sbt`
- Add a LICENSE file for open source (or closed source).
- Clean up the `README.md` (i.e. this file)

Then commit above changes and push it to your repository:
```sh
git commit -m 'Starting %NAME%'
git push origin main
```

If you have any questions or suggestions, feel free to [open an issue](https://github.com/SpinalHDL/SpinalHDL/issues). You can also find other SpinalHDL users and developers on [Gitter](https://gitter.im/SpinalHDL/SpinalHDL).
