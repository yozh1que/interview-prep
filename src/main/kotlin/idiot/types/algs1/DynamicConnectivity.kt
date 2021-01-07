package idiot.types.algs1

// https://www.coursera.org/learn/algorithms-part1/lecture/fjxHC/dynamic-connectivity
// Component = subset of connected objects(ints)
class QuickFind(size: Int) {

    // each entry is an object, actual int value establishes component connection
    // [0, 0, 1] - 3 objects, 2 components
    private val objects = (0 until size).map { it }.toIntArray()

    // if objects belong to the same component
    fun connected(q: Int, w: Int): Boolean {
        return find(q) == find(w)
    }

    // add connection between objects merging their components
    fun union(q: Int, w: Int) {
        if (!connected(q, w)) {
            var i = 0
            while (i < objects.size) {
                if (objects[i] == objects[q]) {
                    objects[i] = objects[w]
                }
                i++
            }
        }
    }

    // finds which component object belongs to
    private fun find(q: Int): Int {
        return objects[q]
    }

    // number of components
    fun count(): Int {
        return objects.distinct().size
    }
}

// https://www.coursera.org/learn/algorithms-part1/lecture/ZgecU/quick-union
class QuickUnion(size: Int) {

    // each entry is an object, actual int value establishes parent in a component tree
    // [0, 0, 1] - 3 objects, 2 components
    private val objects = (0 until size).map { it }.toIntArray()

    // if objects belong to the same component
    fun connected(q: Int, w: Int): Boolean {
        return find(q) == find(w)
    }

    // adds connection between objects merging their tree components
    fun union(q: Int, w: Int) {
        if (!connected(q, w)) {
            objects[find(q)] = find(w)
        }
    }

    // finds tree root
    private fun find(q: Int): Int {
        return if (objects[q] != q) {
            find(objects[q])
        } else {
            q
        }
    }

    // number of components
    fun count(): Int {
        return objects.map { find(it) }.distinct().size
    }

}

// https://www.coursera.org/learn/algorithms-part1/lecture/ZgecU/quick-union
class QuickUnionWeighted(size: Int) {

    // each entry is an object, actual int value establishes parent in a component tree
    // [0, 0, 1] - 3 objects, 2 components
    internal val objects = (0 until size).map { it }.toIntArray()
    private val sizes = IntArray(size) { 1 }

    // if objects belong to the same component
    fun connected(q: Int, w: Int): Boolean {
        return find(q) == find(w)
    }

    // adds connection between objects merging their tree components
    fun union(q: Int, w: Int) {
        if (!connected(q, w)) {
            if (sizes[q] < sizes[w]) {
                objects[find(q)] = find(w)
                sizes[w] += sizes[q]
            } else {
                objects[find(w)] = find(q)
                sizes[q] += sizes[w]
            }
        }
    }

    // finds tree root
    private fun find(q: Int): Int {
        return if (objects[q] != q) {
            find(objects[q])
        } else {
            q
        }
    }

    // number of components
    fun count(): Int {
        return objects.map { find(it) }.distinct().size
    }

}