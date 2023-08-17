//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/17.
//  백준 11651: 좌표 정렬하기 2
//  메모리: 87684KB
//  시간: 252ms

import Foundation

let N: Int = Int(readLine()!)!

var tuple: Array = Array(repeating: [0, 0], count: N)

for i in 0..<N {
    tuple[i] = readLine()!.split(separator: " ").map { Int($0)! }
}

tuple = tuple.sorted { a, b -> Bool in
    if a[1] == b[1] {
        return a[0] < b[0]
    } else {
        return a[1] < b[1]
    }
}

tuple.forEach { a in
    print("\(a[0]) \(a[1])")
}
