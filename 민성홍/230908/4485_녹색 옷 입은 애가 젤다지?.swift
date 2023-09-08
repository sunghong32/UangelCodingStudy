//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/08.
//  백준 4485: 녹색 옷 입은 애가 젤다지?
//  메모리: 79788KB
//  시간: 96ms

import Foundation

let INF = Int(1e9)
let dx = [-1, 0, 1, 0]
let dy = [0, 1, 0, -1]
var caseNumber: Int = 1

func dijkstra(_ graph: [[Int]], _ n: Int) -> Int {
    var distance: [[Int]] = Array(repeating: Array(repeating: INF, count: n), count: n)
    var queue: [(x: Int, y: Int)] = []

    distance[0][0] = graph[0][0]
    queue.append((x: 0,y: 0))

    while !queue.isEmpty {
        let currentPos = queue.removeFirst()
        let x = currentPos.x
        let y = currentPos.y

        for i in 0..<4 {
            let newX = x + dx[i]
            let newY = y + dy[i]

            if newX >= 0 && newX < n && newY >= 0 && newY < n {
                if distance[newX][newY] > distance[x][y] + graph[newX][newY] {
                    distance[newX][newY] = distance[x][y] + graph[newX][newY]
                    queue.append((newX , newY))
                }
            }
        }
    }

    caseNumber += 1

    return distance[n - 1][n - 1]
}

while true {
    let N: Int = Int(readLine()!)!

    if N == 0 {
        break
    } else {
        var cave: [[Int]] = []

        for _ in 0..<N {
            cave.append(readLine()!.split(separator: " ").map { Int($0)! })
        }

        print("Problem \(caseNumber): \(dijkstra(cave,N))")
    }
}
