//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/12.
//  백준 11724: 연결 요소의 개수
//  메모리: 77800KB
//  시간: 608ms

import Foundation

let NM = readLine()!.split(separator: " ").map { Int($0)! }
let N = NM[0], M = NM[1]
var graph = [[Int]](repeating: [Int](repeating: 0, count: 0), count: N + 1)

for _ in 0..<M {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let u = input[0], v = input[1]
    graph[u].append(v)
    graph[v].append(u)
}

var visited = [Bool](repeating: false, count: N + 1)

func dfs(node: Int) {
    visited[node] = true

    for nextNode in graph[node] {
        if !visited[nextNode] {
            visited[nextNode] = true
            dfs(node: nextNode)
        }
    }
}

var answer = 0

for i in 1...N {
    if !visited[i] {
        answer += 1
        dfs(node: i)
    }
}

print(answer)
