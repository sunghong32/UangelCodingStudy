//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 1/12/24.
//  백준 1799: 비숍
//  메모리: 79512 KB
//  시간: 280 ms

import Foundation

func getInput() -> [Int] {
    var result: [Int] = []
    readLine()!.forEach { char in
        if char == " " { return }
        result.append(char == "1" ? 1 : 0)
    }
    return result
}

func classifyVertices(G: [[Int]]) -> ([(Int, Int)], [(Int, Int)]) {
    var AV = [(Int, Int)]()
    var BV = [(Int, Int)]()
    for i in G.indices {
        let st = (i % 2 == 0) ? 0 : 1
        for j in G[i].indices {
            if G[i][j] == 1 {
                if (st + j) % 2 == 0 {
                    AV.append((i,j))
                } else {
                    BV.append((i,j))
                }
            }
        }
    }
    return (AV, BV)
}

func canPlace(at x: Int, y: Int, to: Int, V: inout [(Int, Int)], C: inout [Bool]) -> Bool {
    for i in 0...to {
        let p = (x: V[i].0, y: V[i].1)
        if (p.x == x && p.y == y) || !C[i] { continue}
        var dx = p.x - x
        dx *= dx > 0 ? 1 : -1
        var dy = p.y - y
        dy *= dy > 0 ? 1 : -1
        if dx == dy { return false }
    }
    return true
}

func DFS(_ bdx: Int, _ cnt: Int, V: inout [(Int, Int)], C: inout [Bool]) -> Int {
    if bdx >= V.count { return cnt }
    var maxCount = cnt
    let originC = C
    for i in V[bdx...].indices {
        let pos = V[i]
        let x = pos.0
        let y = pos.1
        if canPlace(at: x, y: y, to: i, V: &V, C: &C) {
            C[i] = true
            maxCount = max(DFS(i + 1, cnt + 1, V: &V, C: &C), maxCount)
        }
        C = originC
    }
    return maxCount
}

let N = Int(readLine()!)!
var G = [[Int]]()
(0..<N).forEach { _ in
    G.append(getInput())
}

var (AV, BV) = classifyVertices(G: G)
var C = [Bool](repeating: false, count: AV.count)
let ans1 = DFS(0, 0, V: &AV, C: &C)
C = [Bool](repeating: false, count: BV.count)
let ans2 = DFS(0, 0, V: &BV, C: &C)
print(ans1 + ans2)
