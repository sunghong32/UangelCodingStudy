//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 1/1/24.
//  백준 1197: 최소 스패닝 트리
//  메모리: 92960 KB
//  시간: 244 ms

import Foundation

class UnionFind {
    var parent: [Int]
    var rank: [Int]

    init(_ n: Int) {
        parent = Array(repeating: -1, count: n)
        rank = Array(repeating: 0, count: n)
    }

    func find(_ x: Int) -> Int {
        if parent[x] == -1 {
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }

    func union(_ x: Int, _ y: Int) {
        let xRoot = find(x)
        let yRoot = find(y)

        if xRoot == yRoot { return }

        if rank[xRoot] < rank[yRoot] {
            parent[xRoot] = yRoot
        } else if rank[xRoot] > rank[yRoot] {
            parent[yRoot] = xRoot
        } else {
            parent[yRoot] = xRoot
            rank[xRoot] += 1
        }
    }
}

let VE: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
let V = VE[0]
let E = VE[1]

var edgesInput: [[Int]] = []
for _ in 0..<E {
    edgesInput.append(readLine()!.split(separator: " ").map { Int($0)! })
}
let edges = edgesInput.map { ($0[0], $0[1], $0[2]) }

var uf = UnionFind(V + 1)
var sortedEdges = edges.sorted { $0.2 < $1.2 }
var result = 0

for edge in sortedEdges {
    if uf.find(edge.0) != uf.find(edge.1) {
        uf.union(edge.0, edge.1)
        result += edge.2
    }
}

print(result)
