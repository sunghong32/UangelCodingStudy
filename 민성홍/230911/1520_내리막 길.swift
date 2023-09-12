//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/12.
//  백준 1520: 내리막 길
//  메모리: 83568KB
//  시간: 100ms

import Foundation

let MN: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
let m: Int = MN[0]
let n: Int = MN[1]
let dx = [-1, 0, 1, 0]
let dy = [0, 1, 0, -1]
var map: [[Int]] = []
var visited: [[Int]] = Array(repeating: Array(repeating: -1, count: n), count: m)
var result: Int = 0

for _ in 0..<m {
    map.append(readLine()!.split(separator: " ").map { Int($0)! })
}

func isValid(_ newX: Int,_ newY: Int,_ visited: [[Int]], _ map: [[Int]], x: Int, y: Int) -> Bool {
    return newX >= 0 && newY >= 0 && newX < m && newY < n && map[x][y] > map[newX][newY]
}

func dfs(x: Int, y: Int) -> Int {
    if x == m - 1, y == n - 1 {
        return 1
    } else {
        if visited[x][y] == -1 {
            visited[x][y] = 0

            for i in 0..<4 {
                let newX = x + dx[i]
                let newY = y + dy[i]

                if isValid(newX, newY, visited, map, x: x, y: y) {
                    visited[x][y] += dfs(x: newX, y: newY)
                }
            }
        }
    }

    return visited[x][y]
}

result = dfs(x: 0, y: 0)
print(result)
