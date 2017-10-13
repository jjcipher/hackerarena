package ha.library.graph

import org.scalatest.{BeforeAndAfter, GivenWhenThen, WordSpec}

class GraphSpec extends WordSpec with GivenWhenThen with BeforeAndAfter {

  def provide = afterWord("provide")

  "A Graph" when {
    "constructed with non-positive integer" should {
      "throw an AssertionError" in {
        assertThrows[java.lang.AssertionError] {
          new Graph(-1)
        }

        assertThrows[java.lang.AssertionError] {
          new Graph(0)
        }
      }
    }

    "constructed with positive integer" should {
      "instantiated a Graph instance that contains the nodes in the ID range" in {
        val graph = new Graph(3)
        assert(graph.nodeSize == 3)
        assert(graph.findNode(1).isDefined)
        assert(graph.findNode(2).isDefined)
        assert(graph.findNode(3).isDefined)
      }
    }
  }

  it should provide {
    "addEdge(Int, Int)" which {
      val graph = new Graph(3)
      val n1 = graph.findNode(1).get
      val n2 = graph.findNode(2).get
      val n3 = graph.findNode(3).get

      "throw an AssertionError when the inputs are not valid" in {
        assertThrows[java.lang.AssertionError] {
          graph.addEdge(0, 1)
        }

        assertThrows[java.lang.AssertionError] {
          graph.addEdge(1, 3)
        }
      }

      "correctly link the given nodes together" in {
        assert(!n1.isDirectlyLinked(n2))
        assert(!n2.isDirectlyLinked(n1))
        assert(!n1.isDirectlyLinked(n3))
        assert(!n3.isDirectlyLinked(n1))
        assert(!n2.isDirectlyLinked(n3))
        assert(!n3.isDirectlyLinked(n2))

        graph.addEdge(1, 2)

        assert(n1.isDirectlyLinked(n2))
        assert(n2.isDirectlyLinked(n1))
        assert(!n1.isDirectlyLinked(n3))
        assert(!n3.isDirectlyLinked(n1))
        assert(!n2.isDirectlyLinked(n3))
        assert(!n3.isDirectlyLinked(n2))
      }
    }

    "groups()" which {
      val graph = new Graph(5)
      val n1 = graph.findNode(1).get
      val n2 = graph.findNode(2).get
      val n3 = graph.findNode(3).get
      val n4 = graph.findNode(4).get
      val n5 = graph.findNode(5).get

      "return groups of nodes correctly" in {
        assert(graph.groups().sameElements(List(List(n1), List(n2), List(n3), List(n4), List(n5))))

        graph.addEdge(1, 2)
        assert(graph.groups().sameElements(List(List(n1, n2), List(n3), List(n4), List(n5))))

        graph.addEdge(3, 4)
        assert(graph.groups().sameElements(List(List(n1, n2), List(n3, n4), List(n5))))

        graph.addEdge(2, 3)
        assert(graph.groups().sameElements(List(List(n1, n2, n3, n4), List(n5))))
      }
    }
  }
}

