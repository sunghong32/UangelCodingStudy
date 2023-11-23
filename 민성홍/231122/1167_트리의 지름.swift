//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 11/22/23.
//  백준 1167: 트리의 지름
//  메모리: 96712 KB
//  시간: 340 ms

import Foundation

let V = Int(readLine()!)!

var tree = [[(Int, Int)]](repeating: [], count: V + 1)
var visited = [Bool](repeating: false, count: V + 1)
var distance = [Int](repeating: 0, count: V + 1)

for _ in 1...V {
    let info = readLine()!.split(separator: " ").map { Int($0)! }
    let node = info[0]

    var index = 1
    while info[index] != -1 {
        let nextNode = info[index]
        let dist = info[index + 1]

        tree[node].append((nextNode, dist))
        index += 2
    }
}

func dfs(_ node: Int, _ dist: Int) {
    visited[node] = true
    distance[node] = dist

    for (nextNode, nextDist) in tree[node] {
        if !visited[nextNode] {
            dfs(nextNode, dist + nextDist)
        }
    }
}

dfs(1, 0)

var startNode = 1
for i in 2...V {
    if distance[i] > distance[startNode] {
        startNode = i
    }
}

visited = [Bool](repeating: false, count: V + 1)
distance = [Int](repeating: 0, count: V + 1)

dfs(startNode, 0)

print(distance.max()!)

