//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/29/23.
//  백준 1007: 벡터 매칭
//  메모리: 79516 KB
//  시간: 948 ms

import Foundation

let T = Int(readLine()!)!

for _ in 0..<T {
    let n = Int(readLine()!)!
    var points = [(Int, Int)]()
    var xTotal = 0
    var yTotal = 0

    for _ in 0..<n {
        let parts = readLine()!.split(separator: " ").compactMap { Int($0) }
        points.append((parts[0], parts[1]))
        xTotal += parts[0]
        yTotal += parts[1]
    }

    var minDistance: Double = Double.infinity

    let half = n / 2
    let combinationsCount = 1 << n

    for bitMask in 0..<combinationsCount {
        var xSum = 0
        var ySum = 0
        var count = 0

        for j in 0..<n {
            if (bitMask & (1 << j)) != 0 {
                count += 1
                xSum += points[j].0
                ySum += points[j].1
            }
        }

        if count == half {
            let xHalfTotal = xTotal - xSum
            let yHalfTotal = yTotal - ySum
            let xDifference = xSum - xHalfTotal
            let yDifference = ySum - yHalfTotal
            let distance = sqrt(Double(xDifference * xDifference + yDifference * yDifference))

            minDistance = min(minDistance, distance)
        }
    }

    print(minDistance)
}
