//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/16.
//  백준 11403: 경로 찾기
//  메모리: 79648KB
//  시간: 24ms

import Foundation

let N = Int(readLine()!)!
var graph = [[Int]]()
for _ in 0..<N {
    graph.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}
var visited = Array(repeating: false, count: N)
var result = Array(repeating: Array(repeating: 0, count: N), count: N)

func dfs(start: Int, now: Int) {
    for i in 0..<N {
        if graph[now][i] == 1 && !visited[i] {
            result[start][i] = 1
            visited[i] = true
            dfs(start: start, now: i)
        }
    }
}

for i in 0..<N {
    dfs(start: i, now: i)
    visited = Array(repeating: false, count: N)
}

for j in result {
    for r in j {
        print(r)
    }
}
