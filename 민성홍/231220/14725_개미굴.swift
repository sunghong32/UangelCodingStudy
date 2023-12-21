//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/20/23.
//  백준 14725: 개미굴
//  메모리: 69252 KB
//  시간: 16 ms

import Foundation

let N = Int(readLine()!)!
var entHouse: [[String]] = []

for _ in 0..<N {
    var line = readLine()!.split(separator: " ").map { String($0) }
    line.removeFirst()
    entHouse.append(line)
}

entHouse.sort { $0.lexicographicallyPrecedes($1) }

class Node {
    var value: String
    var children: [Node] = []

    init(_ value: String) {
        self.value = value
    }
}

let root = Node("")

for path in entHouse {
    var node = root
    for name in path {
        if let child = node.children.first(where: { $0.value == name }) {
            node = child
        } else {
            let child = Node(name)
            node.children.append(child)
            node = child
        }
    }
}

func printTree(_ node: Node, _ depth: Int) {
    if node.value != "" {
        print(String(repeating: "--", count: depth - 1) + node.value)
    }

    for child in node.children.sorted(by: { $0.value < $1.value }) {
        printTree(child, depth + 1)
    }
}

printTree(root, 0)
