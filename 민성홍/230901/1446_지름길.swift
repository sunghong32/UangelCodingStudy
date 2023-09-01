//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/01.
//  백준 1446: 지름길
//  메모리: 79516KB
//  시간: 12ms

import Foundation

let ND: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
let N: Int = ND[0]
let D: Int = ND[1]
var shortCut: [Int] = []
var start: [Int] = []
var end: [Int] = []
var distance: [Int] = []

for i in 0..<(D+1) {
    distance.append(i)
}

for _ in 0..<N {
    let temp: [Int] = readLine()!.split(separator: " ").map { Int($0)! }

    start.append(temp[0])
    end.append(temp[1])
    shortCut.append(temp[2])
}

for j in 0..<(D + 1) {
    if j > 0 {
        distance[j] = min(distance[j - 1] + 1, distance[j])
    }

    for k in 0..<start.count {
        if j == start[k], end[k] <= D,
            distance[start[k]] + shortCut[k] < distance[end[k]]
        {
            distance[end[k]] = distance[start[k]] + shortCut[k]
        }
    }
}

print(distance[D])
