package ha.library.graph

class Graph(n: Int) {
  assert (n >= 1)
  private val ids = (1 to n)
  private val nodes = (1 to n).map(new Node(_)).toSet

  def contains(n: Node): Boolean = nodes.contains(n)

  def findNode(id: Int): Option[Node] = nodes.find(_.id == id)

  def nodeSize: Int = nodes.size

  /**
    * Add an edge that is incident to node a & node b
    * @param a the node a's id
    * @param b the node b's id
    */
  def addEdge(a: Int, b: Int): Unit = {
    assert(a != b)
    assert(ids.contains(1) && ids.contains(b))
    val na = nodes.find(_.id == a).get
    val nb = nodes.find(_.id == b).get
    na.link(nb)
    nb.link(na)
  }

  def groups(): List[List[Node]] = {
    var checkedNodes = scala.collection.mutable.Set[Node]()
    for (
      n <- nodes.toList
      if (!checkedNodes.contains(n))
    ) yield {
      val ln = n.allLinkedNodes
      ln.foreach(checkedNodes += _)
      ln
    }
  }
}

class Node(val id: Int) {
  private var linkedNodes = scala.collection.mutable.Set[Node]()

  def link(that: Node): Unit = linkedNodes += that

  def unlink(that: Node): Unit = linkedNodes -= that

  def directlyLinkedNodes: List[Node] = linkedNodes.toList

  def isDirectlyLinked(that: Node): Boolean = linkedNodes.contains(that)

  def isLinked(that: Node): Boolean = isDirectlyLinked(that) || allLinkedNodes.contains(that)

  def allLinkedNodes: List[Node] = checkLinks(List(this), Nil)

  @annotation.tailrec
  private def checkLinks(toCheck: List[Node], checked: List[Node]): List[Node] = {
    (toCheck, checked) match {
      case (Nil, _) => checked
      case (x :: xs, _) if (!checked.contains(x)) => checkLinks(xs ::: x.directlyLinkedNodes, checked ::: x :: Nil)
      case (x :: xs, _) => checkLinks(xs, checked)
    }
  }
}
