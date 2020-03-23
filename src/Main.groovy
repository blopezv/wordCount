/**
 * Created by Brenda on 3/20/2020.
 */
class Main {
    static void main(String[] args) {
        String fileName = "src/resources/words.txt"
        def file = new File(fileName)
        def content = file.getText('UTF-8')

        System.out.println("File Found : " + file.exists())
        wordFrequency(content, 10)
    }

    static def wordFrequency = { String content, int n ->
        def mapCounts = [:]
        content.toLowerCase().split(/\W+/).each {
            mapCounts[it] = (mapCounts[it] ?: 0) + 1
        }
        def top = (mapCounts.sort { a, b -> b.value <=> a.value }.collect { it })[0..<n]
        println "Word Frequency\n==== ==== ========="
        (0..<n).each { printf("%4d %-4s %9d\n", it + 1, top[it].key, top[it].value) }
    }
}
