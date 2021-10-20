1.  What will happen if you will start the vagrant machine without `$vagrant init`. Why?<br>
    - Will get this error<span style="color:red">
      'A Vagrant environment or target machine is required to run this
      command. Run `vagrant init` to create a new Vagrant environment. Or,
      get an ID of a target machine from `vagrant global-status` to run
      this command on. A final option is to change to a directory with a
      Vagrantfile and to try again.`</span><br>
    - Because the environment needed for vagrant to run is not yet up yet and there is no Vagrantfile
2.  To bring up the Vagrant virtual environment, you can use `$vagrant up`. What will happen after the command?
    - Vagrant will do the following: check if the box (image) is up to date, clearing any previously set forwared ports, clearing any previously set network interface, set network interface, set fowarding ports, boot VMs, ..., mounts shared folder, run the provision config...
3.  How do you access (login into) virtual machine created with vagrant?
    - `vagrant ssh`
4.  What is a BOX in Vagrant?
    - Like a docker image
5.  What is Provider in Vagrant?
    - Different sources for boxes
6.  What is Provisioner in Vagrant?
    - A thing that lets you install softwares on your virtual machine
7.  What is Vagrantfile?
    - Like dockerfile, it describe which boxes/images to use and their specific configuration, it feels a lot like docker-compose
8.  What are Synced Folders in Vagrant?
    - It a folder in the virtual machine that is synced with the folder in which the Vagrantfile is located
9.  What is Multi-Machine environment in Vagrant?
    - In the Vagrantfile we can specify to run multiple machines
10. How do you define multiple machines in Vagrant?

    - ```config.vm.define "node1" do |subconfig|      subconfig.vm.box = BOX_IMAGE # you can use    different image here if you need end

      ```

    ```

    ```

11. What does `vagrant push` do?

    - Push the content of the shared folder to a pre-defined remote server in the Vagrantfile

12. What does `vagrant box list` do?
    - List the different providers
13. What does `vagrant box outdated` do?
    - Check boxes for update
14. What does `vagrant box prune` do?
    - Remove old versions of installed boxes, vagrant will ask for confirmation for currently in use boxes
15. What does `vagrant box remove` do?
    - Remove box with matched name
16. What does `vagrant box repackage` do?
    - Build box in a different way (different version, provider,...)
17. What does `vagrant box update` do?
    - Update box for current Vagrant environment if updates are available
18. What does `vagrant connect` do?
    - Make ports public
19. What does `vagrant destroy` do?
    - Delete box
