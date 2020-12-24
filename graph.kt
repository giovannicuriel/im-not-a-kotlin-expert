var NODE_ID=50
var EDGE_ID=70

class Edge(val sourceId: Int, val destId: Int, val weight: Int) {
    val edgeId = EDGE_ID;
    init {
        EDGE_ID = EDGE_ID + 1;
    }
    
    override fun toString(): String {
        return "${this.edgeId}"
    }
}

class Node private constructor (val nodeId: Int) {
    constructor(): this(NODE_ID) {
        NODE_ID = NODE_ID + 1;
    }
    
    var edges = mutableSetOf<Edge>()
        private set
    
    fun connectTo(otherId: Int, weight: Int) {
        val edge = Edge(this.nodeId, otherId, weight)
        edges.add(edge);
    }
    
    override fun toString(): String {
        return "[${this.nodeId}]: ${edges.fold("") { acc, el -> acc + ',' + el.toString()} }";
    }
    
}

fun main() {
    var e1 = Edge(10, 20, 100);
    var e2 = Edge(10, 20, 100);
    var e3 = Edge(10, 20, 100);
    println("${e3}");
    var n1 = Node();
    var n2 = Node();
    
    n1.connectTo(n2.nodeId, 100);
    println("${n1}");
}