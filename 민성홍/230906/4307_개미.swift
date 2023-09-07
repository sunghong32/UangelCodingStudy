//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/08.
//  백준 4307: 개미
//  메모리: 82940KB
//  시간: 144ms

import Foundation

let caseCount: Int = Int(readLine()!)!

for _ in 0..<caseCount {
    var ln: [Int] = readLine()!.split(separator: " ").map { Int($0)! }

    let l: Int = ln[0]
    let n: Int = ln[1]
    var minValue: [Int] = []
    var maxValue: [Int] = []

    for _ in 0..<n {
        let location: Int = Int(readLine()!)!

        minValue.append(min(location, l - location))
        maxValue.append(max(location, l - location))
    }

    print("\(minValue.max()!) \(maxValue.max()!)")
}
