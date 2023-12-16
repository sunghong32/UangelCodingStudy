//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/15/23.
//  백준 18352: 특정 거리의 도시 찾기
//  메모리: 114412 KB
//  시간: 1732 ms

import Foundation

let input: [Int] = readLine()!.split(separator: " ").map{ Int($0)! }
let N = input[0]
let M = input[1]
let K = input[2]
let X = input[3]
var graph: [[Int]] = Array(repeating: [], count: N+1)
var distance: [Int] = Array(repeating: -1, count: N+1)

for _ in 0..<M {
    let road: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
    graph[road[0]].append(road[1])
}

distance[X] = 0
var queue = [X]
var index = 0

while index < queue.count {
    let now = queue[index]
    index += 1

    for next in graph[now] {
        if distance[next] == -1 {
            queue.append(next)
            distance[next] = distance[now] + 1
        }
    }
}

var check = false

for i in 1...N {
    if distance[i] == K {
        print(i)
        check = true
    }
}

if check == false {
    print("-1")
}

