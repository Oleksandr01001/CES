fun main(args: Array<String>) {
    var nombre = "arp -a"
    val proceso = ProcessBuilder("cmd.exe","/c","arp -a > fichero.txt")
    proceso.start()
    print("Hola mundo $nombre\n")



}