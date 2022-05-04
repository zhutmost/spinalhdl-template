<div>
<img src="https://avatars.githubusercontent.com/u/10659437?s=200&v=4" alt="SpinalHDL Logo" align="left" width="40" height="40"/>
<h1 align="left"> SpinalHDL Project Template </h1>
</div>

This repository is a Mill project template to help starting your SpinalHDL works. SpinalHDL officially provides a SBT [template](https://github.com/SpinalHDL/SpinalTemplateSbt), and this repository is inspired by [Chisel](https://github.com/freechipsproject/chisel-template) and introduces some GitHub Actions to get you started with a clean project.

You can choose this template or the [official one](https://github.com/SpinalHDL/SpinalTemplateSbt) at will.

## Dependencies

### JDK

Before starting, please make sure you have a JDK >= 8 installed. You can install a JDK through the package manager that comes with your OS, or just download a prebuilt binaries such as [AdoptOpenJDK](https://adoptopenjdk.net).

To install a JDK LTS:

```sh
# macOS with Homebrew
brew install openjdk@11
# Ubuntu
apt install default-jdk
```

### Mill Build Tool

Mill is a powerful and easy-to-use build tool by [Haoyi Li](https://github.com/lihaoyi).

To install Mill:
```sh
# macOS with Homebrew
brew install mill
```

To install mill on other platforms, please visit [its documentation](https://com-lihaoyi.github.io/mill/mill/Intro_to_Mill.html).

### Verilator (optional)

If you want to run the Scala-written testbench, you need to install a simulation tool, such as Verilator.

To install Verilator:
```sh
# macOS with Homebrew
brew install verilator
# Ubuntu
apt install verilator
```

Sometimes the Verilator version installed with the package manager is too old, and you need to compile it manually. [Here](https://verilator.org/guide/latest/install.html) are the steps to compile it from scratch.

To veiw the `.vcd` files generated in simulation, a waveform view tool is also required. You can use GTKWave or other commercial tools.

### Intellij IDEA (optional)

Intellij IDEA is an IDE widely used in the Scala community. We strongly recommend you to use it, if you need an IDE.

Intellij IDEA is developed by JetBrains, and you can download it from [here](https://www.jetbrains.com/idea/)(the free Community Edition is good enough). You also need to install its Scala plugin (when you run Intellij IDEA the first time, it will ask you about it).

Sometimes you may need to specify some paths like JDK in the IDE preferences.

## Get started

### Create a repository from the template

This repository is a Github template. You can create your own repository from it by clicking the green `Use this template` in the top right.
Please leave `Include all branches` **unchecked**; checking it will pollute the history of your new repository.
For more information, see ["Creating a repository from a template"](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/creating-a-repository-from-a-template).

**Do NOT clone this repository directly to the local.**

### Wait for the template cleanup workflow to complete

After using the template to create your own blank project, please wait a minute or two for the `Template cleanup` workflow to run which will removes some template-specific stuff from the repository (like the LICENSE).
Refresh the repository page in your browser until you see a 2nd commit by `actions-user` titled `Template cleanup`.

### Clone your repository

Once you have created a repository from this template and the `Template cleanup` workflow has completed, you can click the green `Code` to get a link for cloning your repository.

```sh
git clone git@github.com:%REPOSITORY%.git
cd %NAME%
```
(The variables wrapped in `%` will be filled in by the template cleanup) <!-- #REMOVE-ON-CLEANUP# -->

### Try the example code

Now you have a working SpinalHDL project. Some example RTL code written in Scala, which implements a simple counter, can be found in `mylib/src/mylib/MyTop.scala`.
And `mylib/test/src/mylib/MyTopSimSpec.scala` is its corresponding testbench.

Open a terminal in the root of your cloned repository and run `mill mylib.run`. The first time it runs, the process may take some minutes to download dependencies.

```sh
# Emit Verilog RTL of your design
mill mylib.run

# Run its Scala-written testbench
mill mylib.test.testSim
```

### Dive into SpinalHDL and have fun!

It's time to create your own hardware! And you will discover the charm of SpinalHDL.

Don't forget:
- Add a LICENSE file for open source (or closed source). ([How to select a license?](https://docs.github.com/en/communities/setting-up-your-project-for-healthy-contributions/adding-a-license-to-a-repository))
- Set project organization and other publish settings in `build.sc`.
- Clean up the `README.md` (i.e. this file) and add your own content.
- Replace the example SpinalHDL code with yours.

Then commit above changes and push it to your repository:
```sh
git commit -m 'Starting %NAME%'
git push origin main
```

To open this project in IDE (such as IDEA), please export the BSP configuration first.
```sh
mill mill.bsp.BSP/install
```

### For more infomation

Visit the [documentation](https://spinalhdl.github.io/SpinalDoc-RTD) for more SpinalHDL usage.
If you have any questions or suggestions about this template itself, please [open an issue](https://github.com/zhutmost/spinalhdl-template/issues).
