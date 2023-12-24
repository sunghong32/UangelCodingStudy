//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/22/23.
//  백준 7569: 토마토
//  메모리: 138636 KB
//  시간: 384 ms

import Foundation

typealias Tomato = (depth: Int, row: Int, column: Int, day: Int)

func solution() -> Int {
    let directions = [(-1,0,0), (1,0,0), (0,-1,0), (0,1,0), (0,0,-1), (0,0,1)]
    let boxDimensions = readLine()!.split(separator: " ").map { Int(String($0))! }
    let width = boxDimensions[0]
    let height = boxDimensions[1]
    let depth = boxDimensions[2]
    var boxes = [[[Int]]](repeating: [[Int]](repeating: [Int](repeating: 0, count: width), count: height), count: depth)
    var queue = [Tomato]()
    var maxDays = 0

    for z in 0..<depth {
        for x in 0..<height {
            let rows = readLine()!.split(separator: " ").map { Int(String($0))! }
            for y in 0..<width {
                boxes[z][x][y] = rows[y]
                if rows[y] == 1 {
                    queue.append((z, x, y, 0))
                }
            }
        }
    }

    func bfs() {
        var index = 0

        while index < queue.count {
            let currentTomato = queue[index]
            index += 1
            maxDays = max(maxDays, currentTomato.day)

            for i in 0..<6 {
                let nextRow = currentTomato.row + directions[i].0
                let nextColumn = currentTomato.column + directions[i].1
                let nextDepth = currentTomato.depth + directions[i].2

                if 0 <= nextRow, nextRow < height, 0 <= nextColumn, nextColumn < width, 0 <= nextDepth, nextDepth < depth, boxes[nextDepth][nextRow][nextColumn] == 0 {
                    queue.append((nextDepth, nextRow, nextColumn, currentTomato.day + 1))
                    boxes[nextDepth][nextRow][nextColumn] = 1
                }
            }
        }
    }

    bfs()

    for z in 0..<depth {
        for x in 0..<height {
            for y in 0..<width {
                if boxes[z][x][y] == 0 {
                    return -1
                }
            }
        }
    }

    return maxDays
}

print(solution())
