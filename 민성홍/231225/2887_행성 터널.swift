//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/25/23.
////  백준 2887: 행성 터널
////  메모리: 106008 KB
////  시간: 384 ms

import Foundation

let n = Int(readLine()!)!
var parent: [Int] = Array(repeating: 0, count: n + 1)
var edges: [(cost: Int, a: Int, b: Int)] = []
var nodes: [(x: Int, y: Int, z: Int, idx: Int)] = []

for i in 1...n {
    parent[i] = i
    let node = readLine()!.split(separator: " ").map { Int(String($0))! }
    nodes.append((node[0], node[1], node[2], i))
}

nodes.sort(by: { $0.x < $1.x })
for i in 0..<n-1 {
    edges.append((abs(nodes[i].x-nodes[i+1].x), nodes[i].idx, nodes[i+1].idx))
}

nodes.sort(by: { $0.y < $1.y })
for i in 0..<n-1 {
    edges.append((abs(nodes[i].y-nodes[i+1].y), nodes[i].idx, nodes[i+1].idx))
}

nodes.sort(by: { $0.z < $1.z })
for i in 0..<n-1 {
    edges.append((abs(nodes[i].z-nodes[i+1].z), nodes[i].idx, nodes[i+1].idx))
}

edges.sort(by: { $0.cost < $1.cost })

func find(_ x: Int) -> Int {
    if x == parent[x] {
        return x
    } else {
        parent[x] = find(parent[x])
        return parent[x]
    }
}

func union(_ a: Int, _ b: Int) {
    let parentA = find(a)
    let parentB = find(b)

    if parentA < parentB {
        parent[parentB] = parentA
    } else {
        parent[parentA] = parentB
    }
}

var result = 0
for edge in edges {
    if find(edge.a) != find(edge.b) {
        union(edge.a, edge.b)
        result += edge.cost
    }
}

print(result)
