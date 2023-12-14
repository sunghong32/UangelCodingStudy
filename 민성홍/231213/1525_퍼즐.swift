//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/13/23.
//  백준 1525: 퍼즐
//  메모리: 105556 KB
//  시간: 256 ms

import Foundation

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]
var puzzle: [[Int]] = []

for _ in 0..<3 {
    puzzle.append(readLine()!.split(separator: " ").map { Int($0)! })
}

var dist: [[Int]: Int] = [:]
let flatPuzzle = puzzle.flatMap { $0 }
var q: [[Int]] = []
var head = 0

dist[flatPuzzle] = 0
q.append(flatPuzzle)

while head < q.count {
    let cur = q[head]
    head += 1
    let z = cur.firstIndex(of: 0)!
    let x = z / 3
    let y = z % 3
    for dir in 0..<4 {
        let nx = x + dx[dir]
        let ny = y + dy[dir]
        if nx >= 0 && nx < 3 && ny >= 0 && ny < 3 {
            var temp = cur
            temp.swapAt(x * 3 + y, nx * 3 + ny)
            if dist[temp] == nil {
                dist[temp] = dist[cur]! + 1
                q.append(temp)
            }
        }
    }
}

let answer = [1, 2, 3, 4, 5, 6, 7, 8, 0]

if dist[answer] == nil {
    print("-1")
} else {
    print(dist[answer]!)
}
