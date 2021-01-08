package idiot.types.prep.hackerrank.challenges

// https://www.hackerrank.com/challenges/contacts/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
fun contacts(queries: Array<Array<String>>): Array<Int> = getWordCountByPrefixInTrie(queries)

fun getWordCountByPrefixInTrie(queries: Array<Array<String>>): Array<Int> {
    val trie = Trie()
    val finds = mutableListOf<Int>()
    queries.forEach {
        when (it.first()) {
            "add" -> trie.put(it[1])
            "find" -> finds.add(trie.getWordCountForPrefix(it[1]))
        }
    }
    return finds.toTypedArray()
}

class Trie {

    private val root = mutableMapOf<Char, Node>()

    class Node(
        val char: Char,
        val children: MutableMap<Char, Node> = mutableMapOf(),
        var wordEnd: Boolean = false
    )

    fun put(query: String) {
        var lastNode: Node? = null
        var level: MutableMap<Char, Node> = root
        var i = 0
        while (i < query.length) {
            level[query[i]].also { node ->
                if (node == null) {
                    while (i < query.length) {
                        level[query[i]] = Node(query[i]).apply {
                            lastNode = this
                            level = children
                        }
                        i++
                    }
                } else {
                    level = node.children
                    i++
                }
            }
        }
        lastNode?.wordEnd = true
    }

    fun getWordCountForPrefix(prefix: String): Int {
        var node: Node? = null
        var level: MutableMap<Char, Node> = root
        var i = 0

        while (i < prefix.length) {
            val innerNode = level[prefix[i]]
            if (innerNode != null) {
                node = innerNode
                level = innerNode.children
                i++
            } else {
                return 0
            }
        }
        return node?.let { getSizeRecursive(it) } ?: 0
    }

    private fun getSizeRecursive(node: Node?): Int {
        return if (node == null) {
            0
        } else {
            (if (node.wordEnd) 1 else 0) + (node.children.takeIf { it.isNotEmpty() }?.let { it.values.map { getSizeRecursive(it) }.reduce { acc, i -> acc + i } }
                ?: 0)
        }
    }

}
