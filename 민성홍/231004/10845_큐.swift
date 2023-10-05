//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/04.
//  백준 10845: 큐
//  메모리: 69504KB
//  시간: 24ms

import Foundation

var N: Int = Int(readLine()!)!
var q: [String] = []

for _ in 0..<N {
    let comm = readLine()!.split(separator: " ")

    if comm[0] == "push" {
        q.append(String(comm[1]))
    } else if comm[0] == "pop" {
        if q != [] {
            print("\(q[0])")
            q.removeFirst()
        } else {
            print(-1)
        }
    } else if comm[0] == "size" {
        print("\(q.count)")
    } else if comm[0] == "empty" {
        if q == [] {
            print(1)
        } else {
            print(0)
        }
    } else if comm[0] == "front" {
        if q == [] {
            print(-1)
        } else {
            print(q[0])
        }
    } else if comm[0] == "back" {
        if q == [] {
            print(-1)
        } else {
            print("\(String(describing: q.last!))")
        }
    }
}
