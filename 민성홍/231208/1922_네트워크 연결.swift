//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/8/23.
//  백준 1922: 네트워크 연결
//  메모리: 84264 KB
//  시간: 200 ms

import Foundation

let N = Int(readLine()!)!
var graph = [[Int]](repeating: [Int](repeating: 10001, count: N+1), count: N+1)
var unionTable: [Int] = []

for i in 0...N {
    unionTable.append(i)
}

typealias Edge = (a: Int, b: Int, cost: Int)
var edges = [Edge]()

for _ in 0..<Int(readLine()!)! {
    let edge = readLine()!.split(separator: " ").map { Int(String($0))! }
    edges.append(Edge((edge[0], edge[1], edge[2])))
}

func find(of idx: Int) -> Int {
    guard unionTable[idx] != idx else { return idx }
    unionTable[idx] = find(of: unionTable[idx])
    return unionTable[idx]
}

func union(_ a: Int, _ b: Int) {
    let aParents = find(of: a)
    let bParents = find(of: b)

    if aParents < bParents {
        unionTable[bParents] = aParents
    } else {
        unionTable[aParents] = bParents
    }
}

edges.sort(by: { $0.cost < $1.cost })
var connectEdges = 0
var connectCost = 0

for (a, b, cost) in edges {
    guard connectEdges < N else { break }
    let aParents = find(of: a)
    let bParents = find(of: b)

    if aParents == bParents {
        continue
    } else {
        union(a, b)
        connectEdges += 1
        connectCost += cost
    }
}

print(connectCost)
