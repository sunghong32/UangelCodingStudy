//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/25.
//  백준 1389: 케빈 베이컨의 6단계 법칙
//  메모리: 79516 KB
//  시간: 20 ms

import Foundation

let INF = 987654321
let NM = readLine()!.split(separator: " ").map{ Int($0)! }
let N = NM[0]
let M = NM[1]

var graph = Array(repeating: Array(repeating: INF, count: N + 1), count: N + 1)
var result = Array(repeating: 0, count: N + 1)

for _ in 0..<M {
    let input =  readLine()!.split(separator: " ").map { Int($0)! }
    let a = input[0]
    let b = input[1]
    graph[a][b] = 1
    graph[b][a] = 1
}

for i in 1...N {
    graph[i][i] = 0
}

for i in 1...N {
    for j in 1...N {
        for k in 1...N {
            graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])
        }
    }
}

for i in 1...N {
    for j in 1...N {
        if graph[i][j] != INF {
            result[i] += graph[i][j]
        }
    }
}

let minBacon = result[1..<result.count].min()
let index = result.firstIndex(of: minBacon!)!
print(index)
