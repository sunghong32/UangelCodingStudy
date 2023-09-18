//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/18.
//  백준 1991: 트리 순회
//  메모리: 69112KB
//  시간: 12ms

import Foundation

let N: Int = Int(readLine()!)!
var treeData: [[String]] = []
var preResult: String = ""
var inOrderResult: String = ""
var postResult: String = ""

for _ in 0..<N {
    treeData.append(readLine()!.split(separator: " ").map { String($0) })
}

class TreeNode {
    var value: String
    var leftChild: TreeNode?
    var rightChild: TreeNode?

    init(value: String) {
        self.value = value
    }
}

class BinaryTree {
    var nodes = [String: TreeNode]()

    func insertNode(parent: String, leftChild: String, rightChild: String) {
        if !nodes.keys.contains(parent) {
            nodes[parent] = TreeNode(value: parent)
        }

        if leftChild != "." {
            nodes[leftChild] = TreeNode(value: leftChild)
            nodes[parent]?.leftChild = nodes[leftChild]
        }

        if rightChild != "." {
            nodes[rightChild] = TreeNode(value: rightChild)
            nodes[parent]?.rightChild = nodes[rightChild]
        }
    }

    func preOrderTraversal(node: TreeNode?) {
        guard let node = node else { return }
        preResult += "\(node.value)"
        preOrderTraversal(node : node.leftChild)
        preOrderTraversal(node : node.rightChild)
    }

    func inOrderTraversal(node: TreeNode?) {
        guard let node = node else { return }
        inOrderTraversal(node: node.leftChild)
        inOrderResult += "\(node.value)"
        inOrderTraversal(node: node.rightChild)
    }

    func postOrderTraversal(node: TreeNode?) {
        guard let node = node else { return }
        postOrderTraversal(node: node.leftChild)
        postOrderTraversal(node: node.rightChild)
        postResult += "\(node.value)"
    }
}

let binaryTree = BinaryTree()

for data in treeData {
    binaryTree.insertNode(
        parent: data[0],
        leftChild: data[1],
        rightChild: data[2]
    )
}

binaryTree.preOrderTraversal(node: binaryTree.nodes["\(treeData[0][0])"])
print(preResult)

binaryTree.inOrderTraversal(node: binaryTree.nodes["\(treeData[0][0])"])
print(inOrderResult)

binaryTree.postOrderTraversal(node: binaryTree.nodes["\(treeData[0][0])"])
print(postResult)
