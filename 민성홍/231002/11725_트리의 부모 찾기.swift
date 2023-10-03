//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/02.
//  백준 11725: 트리의 부모 찾기
//  메모리: 83136KB
//  시간: 252ms

import Foundation

let N: Int = Int(readLine()!)!

var nodes: [[Int]] = Array(repeating: [], count: N + 1)
var visited: Array = Array(repeating: false, count: N + 1)

for _ in 1..<N {
  let value = readLine()!.split(separator: " ").map { Int($0)! }
  nodes[value[0]].append(value[1])
  nodes[value[1]].append(value[0])
}

var parents: Array = Array(repeating: 0, count: N + 1)

func dfs(start: Int, parent: Int) {
  visited[start] = true
  parents[start] = parent

  for i in nodes[start] {
    if !visited[i] {
      dfs(start: i, parent: start)
    }
  }
}

dfs(start: 1, parent: 0)

for i in 2...N {
  print(parents[i])
}
