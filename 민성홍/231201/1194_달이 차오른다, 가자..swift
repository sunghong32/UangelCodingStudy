//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/12/03.
//  백준 1194: 달이 차오른다, 가자.
//  메모리: 79784 KB
//  시간: 40 ms

import Foundation

let dx = [0, 0, 1, -1]
let dy = [1, -1, 0, 0]

func bfs(_ startX: Int, _ startY: Int, _ keys: String, _ map: [[Character]]) -> Int {
    var queue: [(Int, Int, Int)] = []
    var visited: [[[Bool]]] = Array(repeating: Array(repeating: Array(repeating: false, count: 64), count: map[0].count), count: map.count)
    queue.append((startX, startY, 0))
    visited[startX][startY][0] = true

    var steps = 0
    while !queue.isEmpty {
        for _ in 0..<queue.count {
            let (x, y, key) = queue.removeFirst()

            if map[x][y] == "1" {
                return steps
            }

            for i in 0..<4 {
                let nx = x + dx[i]
                let ny = y + dy[i]
                var newKey = key

                if nx < 0 || ny < 0 || nx >= map.count || ny >= map[0].count {
                    continue
                }

                if map[nx][ny] == "#" {
                    continue
                }

                if map[nx][ny].isLowercase {
                    newKey = key | (1 << (map[nx][ny].asciiValue! - 97))
                }

                if map[nx][ny].isUppercase && ((key >> (map[nx][ny].asciiValue! - 65)) & 1) == 0 {
                    continue
                }

                if !visited[nx][ny][newKey] {
                    queue.append((nx, ny, newKey))
                    visited[nx][ny][newKey] = true
                }
            }
        }
        steps += 1
    }
    return -1
}

let nm = readLine()!.split(separator: " ").map { Int($0)! }
var map: [[Character]] = []
var startX = 0
var startY = 0

for i in 0..<nm[0] {
    let row = Array(readLine()!)
    for j in 0..<row.count {
        if row[j] == "0" {
            startX = i
            startY = j
        }
    }
    map.append(row)
}

let result = bfs(startX, startY, "", map)
print(result == -1 ? "-1" : "\(result)")
